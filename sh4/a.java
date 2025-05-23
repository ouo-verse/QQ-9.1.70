package sh4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigOfHall;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigOfHallInput;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R&\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lsh4/a;", "", "", "key", "", "url", "", "c", "Ltrpc/yes/common/YesGameInfoOuterClass$GameConfigInfo;", DownloadInfo.spKey_Config, "b", "Landroidx/lifecycle/LiveData;", "a", "", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/Map;", "iconLiveDataMap", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f433815a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, MutableLiveData<String>> iconLiveDataMap = new LinkedHashMap();

    a() {
    }

    private final synchronized void c(int key, String url) {
        Map<Integer, MutableLiveData<String>> map = iconLiveDataMap;
        Integer valueOf = Integer.valueOf(key);
        MutableLiveData<String> mutableLiveData = map.get(valueOf);
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            map.put(valueOf, mutableLiveData);
        }
        mutableLiveData.postValue(url);
    }

    @NotNull
    public final synchronized LiveData<String> a(int key) {
        MutableLiveData<String> mutableLiveData;
        Map<Integer, MutableLiveData<String>> map = iconLiveDataMap;
        Integer valueOf = Integer.valueOf(key);
        mutableLiveData = map.get(valueOf);
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            map.put(valueOf, mutableLiveData);
        }
        return mutableLiveData;
    }

    public final void b(@NotNull YesGameInfoOuterClass$GameConfigInfo config) {
        Intrinsics.checkNotNullParameter(config, "config");
        YesGameInfoOuterClass$GameConfigOfHallInput yesGameInfoOuterClass$GameConfigOfHallInput = config.room_info.hall_input_config;
        if (yesGameInfoOuterClass$GameConfigOfHallInput != null) {
            a aVar = f433815a;
            String str = yesGameInfoOuterClass$GameConfigOfHallInput.icon_emoji.get();
            Intrinsics.checkNotNullExpressionValue(str, "icon_emoji.get()");
            aVar.c(1, str);
            String str2 = yesGameInfoOuterClass$GameConfigOfHallInput.icon_emoji_select.get();
            Intrinsics.checkNotNullExpressionValue(str2, "icon_emoji_select.get()");
            aVar.c(2, str2);
            String str3 = yesGameInfoOuterClass$GameConfigOfHallInput.icon_profile.get();
            Intrinsics.checkNotNullExpressionValue(str3, "icon_profile.get()");
            aVar.c(3, str3);
            String str4 = yesGameInfoOuterClass$GameConfigOfHallInput.icon_create_team.get();
            Intrinsics.checkNotNullExpressionValue(str4, "icon_create_team.get()");
            aVar.c(4, str4);
            String str5 = yesGameInfoOuterClass$GameConfigOfHallInput.icon_mic_on.get();
            Intrinsics.checkNotNullExpressionValue(str5, "icon_mic_on.get()");
            aVar.c(5, str5);
            String str6 = yesGameInfoOuterClass$GameConfigOfHallInput.icon_mic_off.get();
            Intrinsics.checkNotNullExpressionValue(str6, "icon_mic_off.get()");
            aVar.c(6, str6);
            String str7 = yesGameInfoOuterClass$GameConfigOfHallInput.icon_speaker_on.get();
            Intrinsics.checkNotNullExpressionValue(str7, "icon_speaker_on.get()");
            aVar.c(7, str7);
            String str8 = yesGameInfoOuterClass$GameConfigOfHallInput.icon_speaker_off.get();
            Intrinsics.checkNotNullExpressionValue(str8, "icon_speaker_off.get()");
            aVar.c(8, str8);
            String str9 = yesGameInfoOuterClass$GameConfigOfHallInput.color_bg.get();
            Intrinsics.checkNotNullExpressionValue(str9, "color_bg.get()");
            aVar.c(16, str9);
            String str10 = yesGameInfoOuterClass$GameConfigOfHallInput.color_bg_edit.get();
            Intrinsics.checkNotNullExpressionValue(str10, "color_bg_edit.get()");
            aVar.c(17, str10);
            String str11 = yesGameInfoOuterClass$GameConfigOfHallInput.color_text_hint_edit.get();
            Intrinsics.checkNotNullExpressionValue(str11, "color_text_hint_edit.get()");
            aVar.c(18, str11);
            String str12 = yesGameInfoOuterClass$GameConfigOfHallInput.color_text_edit.get();
            Intrinsics.checkNotNullExpressionValue(str12, "color_text_edit.get()");
            aVar.c(19, str12);
        }
        YesGameInfoOuterClass$GameConfigOfHall yesGameInfoOuterClass$GameConfigOfHall = config.room_info.hall_config;
        if (yesGameInfoOuterClass$GameConfigOfHall != null) {
            a aVar2 = f433815a;
            String str13 = yesGameInfoOuterClass$GameConfigOfHall.icon_online_user_more.get();
            Intrinsics.checkNotNullExpressionValue(str13, "icon_online_user_more.get()");
            aVar2.c(9, str13);
        }
    }
}
