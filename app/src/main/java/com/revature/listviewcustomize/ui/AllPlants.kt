package com.revature.listviewcustomize.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.listviewcustomize.R
import com.revature.listviewcustomize.model.data.Plant
import com.revature.listviewcustomize.model.plants
import com.revature.listviewcustomize.ui.theme.ListViewCustomizeTheme

@Preview(
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO
)

@Composable
fun DefaultPreview() {
    ListViewCustomizeTheme {
        AllPlants(plants)
    }
}

@Composable
fun AllPlants(plantList:List<Plant>) {

    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(id = R.string.title)) }
            )
        }

    ) {

        LazyColumn(

            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {

            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "\uD83C\uDF3F  Plants used for Cancer Treatment",
                        style = MaterialTheme.typography.h1,
                    )
                }
            }

            items(plantList) {

                plant ->

                PlantCard(
                    name = plant.name,
                    description = plant.description,
                    image = plant.imageRes
                )
            }
        }
    }
}