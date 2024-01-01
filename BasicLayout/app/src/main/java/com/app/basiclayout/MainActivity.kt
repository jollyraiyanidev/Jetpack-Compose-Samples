package com.app.basiclayout

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.basiclayout.ui.theme.BasicLayoutTheme
import java.util.*


class MainActivity : BaseActivity() {

    @Composable
    override fun BuildContent() {
        BasicLayoutTheme {
            MySootheApp()
        }
    }

    // Step: Search bar - Modifiers
    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            placeholder = {
                Text(stringResource(R.string.placeholder_search))
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )

    }

    // Step: Align your body - Alignment
    @Composable
    fun AlignYourBodyElement(
        @DrawableRes drawable: Int,
        @StringRes text : Int,
        modifier: Modifier = Modifier
    ) {
        Column( horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier) {
            Image(
                painterResource(id = drawable) ,
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape),


            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            
        }
    }

    // Step: Favorite collection card - Material Surface
    @Composable
    fun FavoriteCollectionCard(
        @DrawableRes drawable: Int,
        @StringRes text : Int,
        modifier: Modifier = Modifier
    ) {
       Surface(
           shape =MaterialTheme.shapes.small,
           modifier = modifier
       ) {
           Row(
               verticalAlignment =Alignment.CenterVertically,
               modifier = Modifier.width(192.dp)
           ) {
               Image(
                   painter = painterResource(drawable),
                   contentDescription = null,
                   contentScale =ContentScale.Crop,
                   modifier = Modifier.size(56.dp)
               )
               Text(stringResource(id = text),
               style = MaterialTheme.typography.labelMedium,
               modifier = Modifier.padding(horizontal = 16.dp)
               )
               
           }

       }
    }

    // Step: Align your body row - Arrangements
    @Composable
    fun AlignYourBodyRow(
        modifier: Modifier = Modifier
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier =modifier){
            items(alignYourBodyData){item ->
                AlignYourBodyElement(
                    drawable = item.drawable,
                    text = item.text)
            }

        }
    }

    // Step: Favorite collections grid - LazyGrid
    @Composable
    fun FavoriteCollectionsGrid(
        modifier: Modifier = Modifier
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier =modifier.height(120.dp))
            {
            items(favoriteCollectionsData){ item ->
                FavoriteCollectionCard(
                    drawable = item.drawable,
                    text = item.text)

            }
        }
    }

    // Step: Home section - Slot APIs
    @Composable
    fun HomeSection(
        @StringRes title :Int,
        modifier: Modifier = Modifier,
        content : @Composable () ->Unit
    ) {

        Column(modifier) {
            Text(stringResource(id = title).uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .paddingFromBaseline(
                        top = 40.dp,
                        bottom = 8.dp
                    )
                    .padding(horizontal = 16.dp))

            content()

        }
    }

    // Step: Home screen - Scrolling
    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {

        Column(
            modifier
                .padding(vertical = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(16.dp))

            SearchBar(Modifier.padding(horizontal = 16.dp))
            HomeSection(title = R.string.recipe_type) {
                AlignYourBodyRow()
                
            }
            HomeSection(title = R.string.favorite_collections) {
                FavoriteCollectionsGrid()
                
            }
            Spacer(Modifier.height(16.dp))

        }
    }

    // Step: Bottom navigation - Material
    @Composable
    private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
       NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceVariant,
           modifier =modifier) {
           NavigationBarItem(selected = true, onClick = { /*TODO*/ },
               icon = {Icon(Icons.Default.ShoppingCart, contentDescription = null)} ,
               label = {
                   Text(text = stringResource(id = R.string.bottom_navigation_home))})


           NavigationBarItem(selected = false, onClick = { /*TODO*/ },
               icon = {Icon(Icons.Default.AccountCircle, contentDescription = null)} ,
               label = {
                   Text(text = stringResource(id = R.string.bottom_navigation_profile))})

       }
    }

    // Step: MySoothe App - Scaffold
    @Composable
    fun MySootheAppPortrait() {
        // Implement composable here
    }

    // Step: Bottom navigation - Material
    @Composable
    private fun SootheNavigationRail(modifier: Modifier = Modifier) {
        // Implement composable here
    }

    // Step: Landscape Mode
    @Composable
    fun MySootheAppLandscape(){
        // Implement composable here
    }

    // Step: MySoothe App
    @Composable
    fun MySootheApp() {
        Scaffold(
            bottomBar = {SootheBottomNavigation()}
        ) {
            padding ->  HomeScreen()

        }
    }

    private val alignYourBodyData = listOf(
        R.drawable.breakfast to R.string.ab1_breakfast,
        R.drawable.main to R.string.ab2_main,
        R.drawable.dessert to R.string.ab3_dessert,
        R.drawable.soup to R.string.ab4_soup,
        R.drawable.salad to R.string.ab5_salad,
        R.drawable.appetizer to R.string.ab6_appetizer,
        R.drawable.drink to R.string.ab7_drink
    ).map { DrawableStringPair(it.first, it.second) }

    private val favoriteCollectionsData = listOf(
        R.drawable.noodles to R.string.fc3_noodle,
        R.drawable.pancake to R.string.fc5_panecake,
        R.drawable.sandwich to R.string.fc2_sandwich,
        R.drawable.dessert to R.string.ab3_dessert,
        R.drawable.noodlesoup to R.string.fc4_noodle_soup,
        R.drawable.soup to R.string.ab4_soup
    ).map { DrawableStringPair(it.first, it.second) }

    private data class DrawableStringPair(
        @DrawableRes val drawable: Int,
        @StringRes val text: Int
    )

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun SearchBarPreview() {
        BasicLayoutTheme() { SearchBar(Modifier.padding(8.dp)) }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun AlignYourBodyElementPreview() {
        BasicLayoutTheme {
            AlignYourBodyElement(
                drawable =R.drawable.breakfast,
                text =R.string.ab1_breakfast,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun FavoriteCollectionCardPreview() {
        BasicLayoutTheme {
            FavoriteCollectionCard(
                drawable =R.drawable.sandwich,
                text = R.string.fc2_sandwich,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun FavoriteCollectionsGridPreview() {
        BasicLayoutTheme { FavoriteCollectionsGrid() }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun AlignYourBodyRowPreview() {
        BasicLayoutTheme { AlignYourBodyRow() }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun HomeSectionPreview() {
        BasicLayoutTheme { HomeSection(title = R.string.recipe_type){
             AlignYourBodyRow()
            }
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun ScreenContentPreview() {
        BasicLayoutTheme { HomeScreen() }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun BottomNavigationPreview() {
        BasicLayoutTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun NavigationRailPreview() {
        BasicLayoutTheme { SootheNavigationRail() }
    }

    @Preview(widthDp = 360, heightDp = 640)
    @Composable
    fun MySoothePortraitPreview() {
        MySootheAppPortrait()
    }

    @Preview(widthDp = 640, heightDp = 360)
    @Composable
    fun MySootheLandscapePreview() {
        MySootheAppLandscape()
    }
}