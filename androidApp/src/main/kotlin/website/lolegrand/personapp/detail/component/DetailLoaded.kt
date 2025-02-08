package website.lolegrand.personapp.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import website.lolegrand.personapp.R
import website.lolegrand.personapp.detail.model.DetailGenderUI
import website.lolegrand.personapp.detail.model.DetailPersonUI
import website.lolegrand.personapp.theme.PersonAppTheme

@Composable
fun DetailLoaded(
    person: DetailPersonUI,
    onBack: () -> Unit,
    onDelete: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        DetailLoadedHeader(
            gender = person.gender,
            pictureUrl = person.pictureUrl,
            onBack = onBack,
            onDelete = onDelete,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = person.name,
            style = PersonAppTheme.typography.h1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            DetailInformationRow(
                key = "Address",
                value = person.address,
            )

            DetailInformationRow(
                key = "Email",
                value = person.email,
            )

            DetailInformationRow(
                key = "Age",
                value = "${person.age} y.o.",
            )

            DetailInformationRow(
                key = "Phone",
                value = person.phone,
            )

            DetailInformationRow(
                key = "Cell",
                value = person.cell,
            )
        }
    }
}

@Composable
private fun DetailInformationRow(
    key: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Text(
            text = key,
            style = PersonAppTheme.typography.b2,
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = value,
            style = PersonAppTheme.typography.p2,
            textAlign = TextAlign.End,
        )
    }
}

@Composable
private fun DetailLoadedHeader(
    gender: DetailGenderUI,
    pictureUrl: String,
    onBack: () -> Unit,
    onDelete: () -> Unit,
) {
    var pictureSize by remember { mutableStateOf(IntSize.Zero) }
    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                with(density) { (pictureSize.height.toDp() * 5) / 4 + WindowInsets.systemBars.getTop(density).toDp() }
            ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    with(density) { pictureSize.height.toDp() * 3 / 4 + WindowInsets.systemBars.getTop(density).toDp() }
                )
                .background(
                    color = gender.color
                )
        )

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = with(density) { WindowInsets.systemBars.getTop(density).toDp() })
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
            )
        }

        IconButton(
            onClick = onDelete,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = with(density) { WindowInsets.systemBars.getTop(density).toDp() })
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
            )
        }


        AsyncImage(
            model = pictureUrl,
            contentDescription = "Profile picture",
            placeholder = painterResource(R.drawable.profile_pic),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .aspectRatio(1f)
                .clip(CircleShape)
                .align(Alignment.BottomCenter)
                .onGloballyPositioned { layoutCoordinates ->
                    pictureSize = layoutCoordinates.size
                },
            error = painterResource(R.drawable.profile_pic),
        )
    }
}

@Preview(group = "Element", showBackground = true)
@Composable
private fun DetailLoadedHeaderPreview() {
    PersonAppTheme {
        DetailLoadedHeader(
            gender = DetailGenderUI.MALE,
            pictureUrl = "https://randomuser.me/api",
            onBack = { },
            onDelete = { }
        )
    }
}

@Preview(showSystemUi = true, group = "Screen")
@Composable
private fun DetailLoadedPreview() {
    PersonAppTheme {
        DetailLoaded(
            person = DetailPersonUI(
                id = "1",
                name = "John Doe",
                gender = DetailGenderUI.MALE,
                address = "1234 Elm St",
                longitude = 0.0f,
                latitude = 0.0f,
                email = "a@a.a",
                age = 42,
                phone = "123-456-7890",
                cell = "098-765-4321",
                pictureUrl = "https://randomuser.me/api",
            ),
            onDelete = {},
            onBack = {},
        )
    }
}
