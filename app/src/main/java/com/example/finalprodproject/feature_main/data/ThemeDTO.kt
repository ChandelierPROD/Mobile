package com.example.finalprodproject.feature_main.data;

import com.example.finalprodproject.common.core.dto.Course
import com.example.finalprodproject.feature_roadmap.data.models.UnderTheme
import com.google.gson.annotations.SerializedName;

class ThemeDTO(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("explored")
    val explored: Boolean,

    @SerializedName("author")
    val author: Course.Author?,

    @SerializedName("points")
    val points: Int,

    @SerializedName("students")
    val students: Int,

    @SerializedName("graduates")
    val graduates: Int,

    @SerializedName("underThemeIds")
    val underThemeIds: List<Int>,

    @SerializedName("image")
    val image: String,

    @SerializedName("under")
    val underThemes: List<UnderTheme>?,

    @SerializedName("mark")
    val mark: Int?,

    @SerializedName("videoUrl")
    val videoUrl: String?
) {
//    constructor(id: Int, title: String, String category, String description, boolean explored, Course.Author author, int points, int students, int graduates, List<Integer> underThemeIds, String image) {
//        this.id = id;
//        this.title = title;
//        this.category = category;
//        this.description = description;
//        this.explored = explored;
//        this.author = author;
//        this.points = points;
//        this.students = students;
//        this.graduates = graduates;
//        this.underThemeIds = underThemeIds;
//        this.image = image;
//    }

//    var id: Int = id
//        get() {
//            return field
//        }
//        set(value) {
//            field = value
//        }
//    var title: String = title
//        get() {
//            return field
//        }
//        set(value) {
//            field = value
//        }
//    var category: String = category
//        get() {
//            return field
//        }
//        set(value) {
//            field = value
//        }
//    var description: String = description
//        get() {
//            return field
//        }
//        set(value) {
//            field = value
//        }
//    var explored: Boolean = explored
//        get() {
//            return field
//        }
//        set(value) {
//            field = value
//        }
////    var author: Course.Author? = author
////        get() {
////            return field
////        }
////        set(value) {
////            field = value
////        }
//    var points: Int = points
//        get() {
//            return field
//        }
//        set(value) {
//            field = value
//        }
//    var students: Int = students
//        get() {
//            return field
//        }
//        set(value) {
//            field = value
//        }
}
