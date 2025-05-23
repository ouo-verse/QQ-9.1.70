package wt3;

import androidx.annotation.NonNull;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKVideoInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(int i3, TVKVideoInfo tVKVideoInfo);

        void b(int i3, int i16, String str, int i17, String str2);
    }

    void a(a aVar);

    int b(@NonNull TVKUserInfo tVKUserInfo, @NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, @NonNull String str, int i3, int i16);
}
