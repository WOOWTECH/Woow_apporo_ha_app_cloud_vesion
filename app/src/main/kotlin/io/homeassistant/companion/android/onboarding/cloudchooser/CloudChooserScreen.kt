package io.homeassistant.companion.android.onboarding.cloudchooser

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.homeassistant.companion.android.R
import io.homeassistant.companion.android.common.compose.theme.HADimens
import io.homeassistant.companion.android.common.compose.theme.HATextStyle
import io.homeassistant.companion.android.common.compose.theme.HAThemeForPreview
import io.homeassistant.companion.android.common.compose.theme.LocalHAColorScheme
import io.homeassistant.companion.android.util.compose.HAPreviews

private val ICON_SIZE = 120.dp
private val APPORO_PRIMARY = Color(0xFF8B6B24)

@Composable
internal fun CloudChooserScreen(
    onLocalClick: () -> Unit,
    onCloudClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(horizontal = HADimens.SPACE4),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(HADimens.SPACE6),
    ) {
        val positionPercentage = 0.15f
        Spacer(modifier = Modifier.weight(positionPercentage))

        Image(
            painter = painterResource(R.drawable.ic_apporo_branding),
            contentDescription = null,
            modifier = Modifier.size(ICON_SIZE),
        )

        Text(
            text = "選擇連線方式",
            style = HATextStyle.Headline,
            color = APPORO_PRIMARY,
        )

        Text(
            text = "請選擇您要如何使用連接 Apporo SmartHome",
            style = HATextStyle.Body,
        )

        Spacer(modifier = Modifier.weight(0.1f))

        ChooserCard(
            icon = {
                Image(
                    painter = painterResource(R.drawable.ic_apporo_branding),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
            },
            title = "連結本地設備",
            subtitle = "連結架設好的 Apporo SmartHome",
            onClick = onLocalClick,
        )

        ChooserCard(
            icon = {
                Image(
                    painter = painterResource(R.drawable.ic_apporo_branding),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
            },
            title = "使用雲端服務",
            subtitle = "立即開通使用 Apporo SmartHome",
            onClick = onCloudClick,
        )

        Spacer(modifier = Modifier.weight(1f - positionPercentage))
    }
}

@Composable
private fun ChooserCard(
    icon: @Composable () -> Unit,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        color = LocalHAColorScheme.current.colorSurfaceLow,
        tonalElevation = 2.dp,
    ) {
        Row(
            modifier = Modifier.padding(HADimens.SPACE4),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(HADimens.SPACE4),
        ) {
            icon()
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = title,
                    style = HATextStyle.Body,
                    color = APPORO_PRIMARY,
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = subtitle,
                    style = HATextStyle.BodyMedium,
                    color = LocalHAColorScheme.current.colorOnNeutralNormal,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

@HAPreviews
@Composable
private fun CloudChooserScreenPreview() {
    HAThemeForPreview {
        CloudChooserScreen(onLocalClick = {}, onCloudClick = {})
    }
}
