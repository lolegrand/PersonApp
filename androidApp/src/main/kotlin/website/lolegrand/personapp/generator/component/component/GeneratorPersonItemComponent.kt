package website.lolegrand.personapp.generator.component.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import website.lolegrand.personapp.R
import website.lolegrand.personapp.generator.model.GeneratorGenderUI
import website.lolegrand.personapp.generator.model.GeneratorPersonUI
import website.lolegrand.personapp.theme.PersonAppTheme

@Composable
fun GeneratorPersonItemComponent(
    person: GeneratorPersonUI,
) {
    Column(
        modifier = Modifier
            .background(
                color = person.gender.color,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        AsyncImage(
            model = person.profilePictureUrl,
            contentDescription = "Profile picture",
            placeholder = painterResource(R.drawable.profile_pic),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(64.dp)
                .aspectRatio(1f)
                .clip(CircleShape),
            error = painterResource(R.drawable.profile_pic),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = person.name,
            style = PersonAppTheme.typography.h1,
        )

    }
}

@Preview
@Composable
private fun GeneratorPersonItemComponentPreview() {
    PersonAppTheme {
        GeneratorPersonItemComponent(
            person = GeneratorPersonUI(
                id = "1",
                name = "John Doe",
                gender = GeneratorGenderUI.MALE,
                profilePictureUrl = "https://example.com/image.jpg",
            )
        )
    }
}