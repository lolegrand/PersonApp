package website.lolegrand.personapp.master.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import website.lolegrand.personapp.R
import website.lolegrand.personapp.master.component.component.MasterPersonItemComponent
import website.lolegrand.personapp.master.model.MasterPersonUI
import website.lolegrand.personapp.theme.PersonAppTheme

@Composable
fun MasterLoaded(
    personList: List<MasterPersonUI>,
    onClickPerson: (id: String) -> Unit,
) {
    if (personList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painterResource(id = R.drawable.empty),
                contentDescription = "Empty list",
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "No person found",
                style = PersonAppTheme.typography.h1,
            )

        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }

            items(personList, key = { it.id }) { person ->
                MasterPersonItemComponent(
                    person = person,
                    onClick = onClickPerson,
                )
            }
        }
    }
}