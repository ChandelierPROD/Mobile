package com.example.finalprodproject.feature_roadmap.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.finalprodproject.R;
import com.example.finalprodproject.databinding.RoadmapLayoutBinding;
import com.example.finalprodproject.feature_main.data.RoadmapItem;
import com.example.finalprodproject.feature_roadmap.presentation.adapters.GraphAdapter;

import java.util.ArrayList;;

public class RoadmapFragment extends Fragment {
    private RoadmapLayoutBinding binding;
    private Handler handler;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NavController navController = NavHostFragment.findNavController(this);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.navigate(RoadmapFragmentDirections.actionRoadmapFragmentToStudyFragment());
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = RoadmapLayoutBinding.inflate(inflater, container, false);

        context = requireContext();
        binding.roadmapBack.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                updateProgressBar();
                sendEmptyMessageDelayed(0, 10000);
            }
        };

        handler.sendEmptyMessage(0);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RoadmapFragmentArgs args = RoadmapFragmentArgs.fromBundle(getArguments());
        int receivedArg = args.getId();

        ArrayList<RoadmapItem> roadmapItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            roadmapItems.add(new RoadmapItem("Прямоугольный треугольник" + i, "https://sun1-30.userapi.com/impf/IIhTXspuQTOUh_F0iytqrYnHI-HH8icB61fvsg/P63gBbz4LO4.jpg?size=495x495&quality=100&sign=e5e94b6af75c4f429233d3d023155ca1&c_uniq_tag=2au4eG2oQU-GuN6idcFIfpZk5gf4tqInX2NXx1Q25GI", 10));
        }
        GraphAdapter graphAdapter = new GraphAdapter(roadmapItems);
        graphAdapter.setOnItemClickListener(id -> {
            Bundle bundle = new Bundle();
            bundle.putInt("themeID", id);
            Navigation.findNavController(requireView()).navigate(R.id.action_roadmapFragment_to_deepEduFragment, bundle);
        });

        binding.graphList.setAdapter(graphAdapter);
        binding.graphList.post(() -> binding.graphList.smoothScrollToPosition(9));
    }

    @Override
    public void onResume() {
        super.onResume();

        int screenHeight = getResources().getDisplayMetrics().heightPixels;

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) binding.progressBar.getLayoutParams();
        params.width = screenHeight - 400;
        params.height = 30;


        binding.progressBar.setLayoutParams(params);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (handler != null) handler.removeCallbacksAndMessages(null);
    }

    private void updateProgressBar() {
        if (context != null) {
            int newProgress = binding.progressBar.getProgress() + (int) (Math.random() * 10);
            if (newProgress > binding.progressBar.getMax()) {
                newProgress = binding.progressBar.getMax();
            }
            binding.progressBar.setProgress(newProgress);

            if (newProgress <= 25) {
                binding.progressBar.setProgressTintList(ContextCompat.getColorStateList(context, R.color.color_stroke_accent_themed));
                binding.progressText.setText("3");
            } else if (newProgress <= 75) {
                binding.progressBar.setProgressTintList(ContextCompat.getColorStateList(context, R.color.color_yellow));
                binding.progressText.setText("4");
            } else if (newProgress <= 95) {
                binding.progressBar.setProgressTintList(ContextCompat.getColorStateList(context, R.color.color_stroke_negative));
                binding.progressText.setText("5");
            }
        }
    }

}
