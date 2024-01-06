package com.example.personalportifolioapp

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun NavigationHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, end = 18.dp, top = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.previous_screen),
            contentDescription = "Back Press Icon",
        )
        Text(
            text = "Profile",
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )

//        Icon(
//            painter = painterResource(id = R.drawable.add_profile_icon),
//            contentDescription = "add new profile", Modifier.clickable {
//                Log.d("", "navigate to next screen")
//                navController.navigate(Screen.AddProfileScreen.route)
//            }
//        )


    }
}


@Composable
fun ProfileItem(
    developerProfileDataClass: DeveloperProfileDataClass,
    onItemClick: (DeveloperProfileDataClass) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onItemClick(developerProfileDataClass)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                Box(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.default_profile_image),
                        contentDescription = "default profile image",
                        Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .border(1.dp, Color.Gray, RoundedCornerShape(15.dp))
                            .width(50.dp)
                            .height(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = developerProfileDataClass.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = developerProfileDataClass.jobTitle)
                }
            }

            Column {
                IconButton(onClick = { Log.d("", "Profile deleted") }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_delete_24),
                        contentDescription = "delete profile"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_edit_24),
                        contentDescription = "delete profile"
                    )
                }
            }

        }


    }
}


@Composable
fun Profiles(contentPaddingValues: PaddingValues, navController: NavController) {
    val listOfProfiles by remember {
        mutableStateOf(
            listOf(
                DeveloperProfileDataClass(name = "Sai babu", jobTitle = "Android developer"),
                DeveloperProfileDataClass("Ram", jobTitle = "IOS developer"),
                DeveloperProfileDataClass(name = "Mani", jobTitle = "Android & IOS developer"),
                DeveloperProfileDataClass(name = "Sai babu", jobTitle = "Android developer"),
                DeveloperProfileDataClass("Ram", jobTitle = "IOS developer"),
                DeveloperProfileDataClass(name = "Mani", jobTitle = "Android & IOS developer"),
                DeveloperProfileDataClass(name = "Sai babu", jobTitle = "Android developer"),
                DeveloperProfileDataClass("Ram", jobTitle = "IOS developer"),
                DeveloperProfileDataClass(name = "Mani", jobTitle = "Android & IOS developer"),
                DeveloperProfileDataClass(name = "Sai babu", jobTitle = "Android developer"),
                DeveloperProfileDataClass("Ram", jobTitle = "IOS developer"),
                DeveloperProfileDataClass(name = "Mani", jobTitle = "Android & IOS developer")
            )
        )
    }
    LazyColumn(
        modifier = Modifier.padding(18.dp),
        contentPadding = contentPaddingValues,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(listOfProfiles) { devProfile ->
            ProfileItem(devProfile, onItemClick = {
                navController.navigate(Screen.AddProfileScreen.route)
                Log.d("The Dev Data is",it.name)
            })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ), title = {
            Text(
                "Developer Profiles", maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        }, navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate(Screen.AddProfileScreen.route)
        }) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }, bottomBar = {

    }) {
        Profiles(it, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProfileScreen(navController: NavController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ), title = {
            Text(
                "Developer Profiles", maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        }, navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        })
    }) {
        AddProfileBody(it)
    }
}

@Composable
fun AddProfileBody(contentPaddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(top = contentPaddingValues.calculateTopPadding())) {
        Image(
            painter = painterResource(id = R.drawable.profile_cover_page),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .aspectRatio(2f),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .border(5.dp, Color.Gray)
                .width(160.dp)
                .height(160.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Text(text = "Here You can Edit your profile")
    }
}