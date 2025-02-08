package website.lolegrand.personapp.ds

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun AnimatedLoader(
    loaderColor: Color,
    progress: Float,
    modifier: Modifier = Modifier,
) {
    val currentProgress by animateFloatAsState(targetValue = progress, label = "progress")

    var ticks by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(Unit) {
        while (true) {
            ticks -= 0.01f % (2 * PI).toFloat()
            delay(1)
        }
    }

    Canvas(
        modifier = modifier
            .height(14.dp)
            .fillMaxWidth()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val points = mutableListOf<Offset>()
        val maxProgress = (canvasWidth * currentProgress).toInt()
        for (x in 0 until maxProgress) {
            val waveMaxAmpl = 0.9f
            val reachPercent = x.toFloat() / maxProgress
            val waveHeight = when {
                reachPercent < 0.1f -> (reachPercent * 10f) * waveMaxAmpl
                reachPercent > 0.9f -> ((1 - reachPercent) * 10f) * waveMaxAmpl
                else -> waveMaxAmpl
            }

            val y = canvasHeight / 2 + (canvasHeight / 2) * waveHeight * sin(x.toDouble() / 20 + ticks).toFloat()
            points.add(Offset(x.toFloat(), y))
        }

        drawLine(
            color = Color.Gray,
            start = Offset(currentProgress * canvasWidth, canvasHeight / 2),
            end = Offset(canvasWidth, canvasHeight / 2),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
        )

        drawPoints(
            points = points,
            pointMode = PointMode.Points,
            color = loaderColor,
            strokeWidth = 10f
        )

        drawLine(
            color = if (progress == 0f) Color.Gray else loaderColor,
            start = Offset(0f, 0f),
            end = Offset(0f, canvasHeight),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
        )

        drawLine(
            color = if (progress == 1f) loaderColor else Color.Gray,
            start = Offset(canvasWidth, 0f),
            end = Offset(canvasWidth, canvasHeight),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
        )
    }
}