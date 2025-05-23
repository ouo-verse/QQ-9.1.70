package x;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f446807a = true;

    public static Drawable a(Context context, @DrawableRes int i3, @Nullable Resources.Theme theme) {
        return c(context, context, i3, theme);
    }

    public static Drawable b(Context context, Context context2, @DrawableRes int i3) {
        return c(context, context2, i3, null);
    }

    private static Drawable c(Context context, Context context2, @DrawableRes int i3, @Nullable Resources.Theme theme) {
        try {
            if (f446807a) {
                return e(context2, i3, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e16) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i3);
            }
            throw e16;
        } catch (NoClassDefFoundError unused2) {
            f446807a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i3, theme);
    }

    private static Drawable d(Context context, @DrawableRes int i3, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i3, theme);
    }

    private static Drawable e(Context context, @DrawableRes int i3, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i3);
    }
}
