package fr.thomasbernard03.composents.animations

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val animationTime = 300

private fun getExitTransition(animatedContentScope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    animatedContentScope.apply {
        return slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(animationTime)
        )
    }
}

private fun getPopExitTransition(animatedContentScope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    animatedContentScope.apply {
        return slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(animationTime)
        )
    }
}

private fun getEnterTransition(animatedContentScope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    animatedContentScope.apply {
        return slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(animationTime)
        )
    }
}

private fun getPopEnterTransition(animatedContentScope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    animatedContentScope.apply {
        return slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(animationTime)
        )
    }
}

fun NavGraphBuilder.animatedComposable(
    route: String,
    arguments : List<NamedNavArgument> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        arguments = arguments,
        enterTransition = { getEnterTransition(this) },
        exitTransition = { getExitTransition(this) },
        popEnterTransition = { getPopEnterTransition(this) },
        popExitTransition = { getPopExitTransition(this) }
    ) { backStackEntry ->
        content(backStackEntry)
    }
}