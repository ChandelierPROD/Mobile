package com.example.finalprodproject.feature_study_page.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalprodproject.R
import com.example.finalprodproject.common.coreui.cources_category_item.CoursesCategoryItemDelegateAdapter
import com.example.finalprodproject.common.coreui.cources_category_item.CoursesCategoryItemViewModel
import com.example.finalprodproject.databinding.StudyFragmentBinding
import com.example.finalprodproject.feature_study_page.data.repository.StudyRepository
import com.example.finalprodproject.feature_study_page.presentation.mapper.CoursesDataMapper.mapToViewModelByCategories
import com.example.finalprodproject.feature_study_page.presentation.mapper.CoursesDataMapper.mapToViewModelsList
import com.example.finalprodproject.utils.adapter.CompositeAdapter
import com.example.finalprodproject.utils.image_loader.ImageLoader

class StudyFragment : Fragment() {

    private var _binding: StudyFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModelFactory by lazy {
        StudyViewModelFactory(
            StudyRepository(
                context = requireContext()
            )
        )
    }
    private val viewModel: StudyViewModel by viewModels { viewModelFactory }

    private val coursesCompositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(CoursesCategoryItemDelegateAdapter { _, courseItemViewModel ->
                val direction: NavDirections = with(courseItemViewModel) {
                    if (!started && !explored) {
                        com.example.finalprodproject.feature_study_page.presentation.StudyFragmentDirections.actionStudyFragmentToStudyInformationFragment(
                            courseItemViewModel.id
                        )
                    } else if (started && !explored) {
                        com.example.finalprodproject.feature_study_page.presentation.StudyFragmentDirections.actionStudyFragmentToRoadmapFragment(
                            courseItemViewModel.id
                        )
                    } else {
                        com.example.finalprodproject.feature_study_page.presentation.StudyFragmentDirections.actionStudyFragmentToCourseEndFragment(
                            courseItemViewModel.title,
                            courseItemViewModel.points
                        )
                    }
                }
                findNavController().navigate(direction)
            })
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = StudyFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        if (viewModel.allCoursesData.value == null) {
            viewModel.allCoursesData.observe(viewLifecycleOwner) {
                coursesCompositeAdapter.submitList(getCombinedLists())
            }
        } else {
           // viewModel.clearAllCourses()
        }
        if (viewModel.myCoursesData.value == null) {
            viewModel.myCoursesData.observe(viewLifecycleOwner) {
                coursesCompositeAdapter.submitList(getCombinedLists())
            }
        } else {
            //viewModel.clearMyCourses()
        }
        if (viewModel.profileData.value == null) {
            viewModel.profileData.observe(viewLifecycleOwner) {
                if (it.image != null) {
                    ImageLoader.loadImageWithRoundCorners(
                        imageView = binding.avatar,
                        link = it.image,
                        radius = requireContext().resources.getDimensionPixelSize(R.dimen.margin_medium)
                    )
                }
            }
        }
        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean { return false }
                override fun onQueryTextChange(newText: String?): Boolean {
                    if (!newText.isNullOrEmpty()) {
                        coursesCompositeAdapter.submitList(
                            getCombinedLists().filter {
                                it.title.lowercase().split(" ").any { word -> word.startsWith(newText) }
                            }
                        )
                    } else {
                        coursesCompositeAdapter.submitList(getCombinedLists())
                    }
                    return true
                }
            }
        )
        viewModel.loadAllCourses()
        viewModel.loadMyCourses()
        viewModel.loadProfile()
    }

    private fun initAdapter() {
        binding.mainRecycler.apply {
            layoutManager = LinearLayoutManager(context).apply { setOrientation(LinearLayoutManager.VERTICAL) }
            adapter = coursesCompositeAdapter
        }
    }

    private fun getCombinedLists(): List<CoursesCategoryItemViewModel> {
        val allCoursesCategoryData = ArrayList<CoursesCategoryItemViewModel>().apply {
            viewModel.allCoursesData.value?.let {
                addAll(it.mapToViewModelByCategories())
            }
        }
        val myCoursesCategoryData = ArrayList<CoursesCategoryItemViewModel>().apply {
            viewModel.myCoursesData.value?.let {
                add(CoursesCategoryItemViewModel(
                    title = requireContext().resources.getString(R.string.courses),
                    courses = it.mapToViewModelsList()
                ))
            }
        }

        return myCoursesCategoryData.plus(allCoursesCategoryData)
    }

}