package com.example.movieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header Section
        HeaderSection()

        // Banner Section
        BannerSection()

        Text(
            text = "Now Playing",
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.7f))
                .fillMaxWidth()
                .padding(8.dp),
            color = Color.White,

        )

        // Movie Poster Section
        MoviePosterSection(navController)
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.cgv),
            contentDescription = "CGV Logo",
            modifier = Modifier.size(50.dp)
        )
        Box {
            Text(text = "Welcome to CGV", color = Color.Black, fontSize = 20.sp)
        }
    }
}

@Composable
fun BannerSection() {
    val images = listOf(
        R.drawable.ad1,
        R.drawable.ad2,
        R.drawable.ad3
    )

    var currentIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            currentIndex = (currentIndex + 1) % images.size
        }
    }

    val currentImage = images[currentIndex]

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
    ) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}



@Composable
fun MoviePosterSection(navController: NavHostController) {
    val moviePosters = listOf(
        PosterFilm(namaFilm = "Film 1", posterResId = R.drawable.movie1),
        PosterFilm(namaFilm = "Film 2", posterResId = R.drawable.movie3),
        PosterFilm(namaFilm = "Film 3", posterResId = R.drawable.movie4),

        )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(moviePosters) { index, posterFilm ->
            if (index == 0) {
                ClickableMoviePoster(posterFilm = posterFilm, navController = navController)
            } else {
                NonClickableMoviePoster(posterFilm = posterFilm)
            }
        }
    }
}

@Composable
fun ClickableMoviePoster(posterFilm: PosterFilm, navController: NavHostController) {
    Box(
        modifier = Modifier
            .size(width = 250.dp, height = 400.dp)
            .clickable {
                navController.navigate("seat")
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = posterFilm.posterResId),
            contentDescription = posterFilm.namaFilm,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}



@Composable
fun NonClickableMoviePoster(posterFilm: PosterFilm) {
    Box(
        modifier = Modifier
            .size(width = 250.dp, height = 400.dp),
        contentAlignment = Alignment.Center
    ){
    Image(
        painter = painterResource(id = posterFilm.posterResId),
        contentDescription = posterFilm.namaFilm,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    }
}


data class PosterFilm(val namaFilm: String, val posterResId: Int)

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}