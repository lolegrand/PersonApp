package website.lolegrand.personapp.ds

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import website.lolegrand.personapp.theme.PersonAppTheme

data class TopBarAction(
    val icon: ImageVector,
    val onClick: () -> Unit,
)

@Composable
fun TopBar(
    title: String,
    leftAction: TopBarAction? = null,
    rightAction: TopBarAction? = null,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(vertical = 8.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (leftAction != null) {
                IconButton(
                    onClick = leftAction.onClick,
                ) {
                    Icon(
                        imageVector = leftAction.icon,
                        contentDescription = null,
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))
            }

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = PersonAppTheme.typography.h1
            )

            if (rightAction != null) {
                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = rightAction.onClick,
                ) {
                    Icon(
                        imageVector = rightAction.icon,
                        contentDescription = null,
                    )
                }
            }
        }

        HorizontalDivider(
            color = PersonAppTheme.colors.surfaceContainerHighest,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview() {
    PersonAppTheme {
        Column {
            TopBar(
                title = "Title",
                leftAction = TopBarAction(
                    icon = Icons.AutoMirrored.Filled.ArrowBack,
                    onClick = { }
                ),
                rightAction = TopBarAction(
                    icon = Icons.Default.Add,
                    onClick = { }
                ),
            )

            TopBar(
                title = "Title",
            )
        }
    }
}