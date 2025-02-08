package website.lolegrand.personapp.master.component.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import website.lolegrand.personapp.R
import website.lolegrand.personapp.master.model.MasterGenderUI
import website.lolegrand.personapp.master.model.MasterPersonUI
import website.lolegrand.personapp.theme.PersonAppTheme

@Composable
fun MasterPersonItemComponent(
    person: MasterPersonUI,
    onClick: (id: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val rowColor = when (person.gender) {
        MasterGenderUI.MALE -> PersonAppTheme.colors.colorMale
        MasterGenderUI.FEMALE -> PersonAppTheme.colors.colorFemale
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = rowColor)
            .clickable { onClick(person.id) }
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            )

    ) {
        AsyncImage(
            model = person.profilePicUrl,
            contentDescription = "Profile picture",
            placeholder = painterResource(R.drawable.profile_pic),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(54.dp)
                .border(
                    width = 3.dp,
                    color = PersonAppTheme.colors.surfaceContainerHighest,
                    shape = CircleShape,
                )
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = person.name,
                style = PersonAppTheme.typography.h1,
            )

            Text(
                text = person.email,
                style = PersonAppTheme.typography.p1,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun MasterPersonItemComponentPreview() {
    PersonAppTheme {
        MasterPersonItemComponent(
            person = MasterPersonUI(
                id = "1",
                name = "Mr John Doe",
                profilePicUrl = "https://randomuser.me/api/portraits/men/10.jpg",
                email = "exemple@exemple.com",
                gender = MasterGenderUI.FEMALE,
            ),
            onClick = {},
        )
    }
}
