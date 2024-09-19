package com.example.finalprodproject.feature_main.data;

class RoadmapItem(textParam: String, imageParam: String, scoresParam: Int, idParam: Int) {
    var text: String = textParam
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var image: String = imageParam
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var scores: Int = scoresParam
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var id: Int = idParam
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var isLoad: Boolean = false
        get() {
            return field
        }
        set(value) {
            field = value
        }
}