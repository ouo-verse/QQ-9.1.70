package tv.danmaku.ijk.media.player.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes30.dex */
public @interface CalledByNative {
    String value() default "";
}
