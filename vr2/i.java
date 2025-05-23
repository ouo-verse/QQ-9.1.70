package vr2;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lvr2/i;", "", "Landroid/content/Context;", "context", "", "a", "Landroid/media/AudioManager;", "b", "Landroid/media/AudioManager;", "audioManager", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f443207a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AudioManager audioManager;

    i() {
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        AudioManager audioManager2 = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        audioManager = audioManager2;
        if (audioManager2 == null) {
            QLog.e("TroopAIVoiceChatVolumeHelper", 1, "get audio service err!");
            return false;
        }
        int streamVolume = audioManager2 != null ? SystemMethodProxy.getStreamVolume(audioManager2, 3) : 0;
        AudioManager audioManager3 = audioManager;
        return ((float) streamVolume) / ((float) (audioManager3 != null ? audioManager3.getStreamMaxVolume(3) : 1)) < 0.18f;
    }
}
