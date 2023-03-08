package com.ahr.borutoapp.presentation.screen.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ahr.borutoapp.R
import com.ahr.borutoapp.ui.theme.BorutoAppTheme

@Composable
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = stringResource(id = R.string.explore)) },
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_hero)
                )
            }
        }
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewSearchHero() {
    BorutoAppTheme {
        HomeTopAppBar {
        }
    }
}