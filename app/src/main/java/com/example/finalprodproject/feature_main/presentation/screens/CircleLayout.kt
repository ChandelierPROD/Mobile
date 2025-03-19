package com.example.finalprodproject.feature_main.presentation.screens

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

import androidx.annotation.NonNull

import kotlin.math.cos
import kotlin.math.sin

class CircleLayout(context: Context, attrs: AttributeSet?): View(context, attrs) {
    private var paint: Paint
    private var linePaint: Paint
    private val radius: Float = 100f
    private var count: Int = 0
    private var angleInRadians: Double = Math.toRadians(60.0)
    private var angleInRadians2: Double = Math.toRadians(120.0)

    init {
        paint = Paint()
        paint.color = Color.DKGRAY
        paint.style = Paint.Style.FILL

        linePaint = Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.color = Color.LTGRAY
        linePaint.strokeWidth = 5.0f

        val dashPathEffect = DashPathEffect(floatArrayOf(10f, 10f), 0f)
        linePaint.pathEffect = dashPathEffect
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        val desiredHeight: Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heightMeasureSpec + 100f, getResources().getDisplayMetrics()).toInt()
        val heightMeasureSpecCustom: Int = MeasureSpec.makeMeasureSpec(desiredHeight, MeasureSpec.EXACTLY)

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpecCustom)
    }

    @Override
    override fun onDraw(@NonNull canvas: Canvas) {
        super.onDraw(canvas);
        var centerX: Float = 220f
        var centerY: Float = 150f

        for (i in 0..<count step 1) {
            if (i % 2 == 0) {
                val endX: Float = centerX + (3 * radius * cos(angleInRadians)).toFloat()
                val endY: Float = centerY + (3 * radius * sin(angleInRadians)).toFloat()

                if (i + 1 != count) canvas.drawLine(centerX, centerY, endX, endY, linePaint)

                canvas.drawCircle(centerX, centerY, radius, paint)

                centerX = endX
                centerY = endY
            } else {
                val endX2: Float = centerX + (3 * radius * Math.cos(angleInRadians2)).toFloat()
                val endY2: Float = centerY + (3 * radius * Math.sin(angleInRadians2)).toFloat()

                if (i + 1 != count) canvas.drawLine(centerX, centerY, endX2, endY2, linePaint)
                canvas.drawCircle(centerX, centerY, radius, paint)

                centerX = endX2
                centerY = endY2
            }
        }

    }

    fun addCircle() {
        count++;
        invalidate();
    }
}
