package ro1;

import android.view.View;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.api.impl.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0010R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001d\u0010\u0010R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b\u0007\u0010\u0018R\"\u0010#\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b\u0013\u0010\u0018\u00a8\u0006&"}, d2 = {"Lro1/a;", "", "", "d", "", "toString", "Landroid/view/View;", "a", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "b", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "channelId", "", "c", "I", "getPos", "()I", "f", "(I)V", c.G, "getSessionId", "g", "sessionId", "e", "getLiveRoomId", "liveRoomId", "getCardType", "cardType", "getCoverState", "coverState", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ro1.a, reason: from toString */
/* loaded from: classes13.dex */
public final class LiveAudioReport {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int pos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String sessionId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String liveRoomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int cardType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int coverState;

    public LiveAudioReport(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.channelId = "";
        this.pos = -1;
        this.sessionId = "";
        this.liveRoomId = "";
        this.cardType = -1;
        this.coverState = -1;
    }

    public final void a(int i3) {
        this.cardType = i3;
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final void c(int i3) {
        this.coverState = i3;
    }

    public final void d() {
        boolean z16;
        e.f(this.view, String.valueOf(this.pos));
        e.c(this.view, "em_sgrp_nowplay_room");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_sub_channel_id", this.channelId);
        linkedHashMap.put("sgrp_rank", Integer.valueOf(this.pos));
        boolean z17 = true;
        if (this.sessionId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            linkedHashMap.put("sgrp_subchannel_session_id", this.sessionId);
        }
        if (this.liveRoomId.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            linkedHashMap.put("sgrp_live_room_id", this.liveRoomId);
        }
        int i3 = this.cardType;
        if (i3 != -1) {
            linkedHashMap.put("sgrp_content_card_type", Integer.valueOf(i3));
        }
        linkedHashMap.put("sgrp_cover_state", Integer.valueOf(this.coverState));
        linkedHashMap.put("sgrp_card_state", Integer.valueOf(this.coverState));
        e.e(this.view, linkedHashMap);
        e.b(this.view, "2");
        e.d(this.view, "1");
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveRoomId = str;
    }

    public final void f(int i3) {
        this.pos = i3;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    @NotNull
    public String toString() {
        return "LiveAudioReport(channelId='" + this.channelId + "', pos=" + this.pos + ", sessionId='" + this.sessionId + "', liveRoomId='" + this.liveRoomId + "', cardType=" + this.cardType + ", coverState=" + this.coverState + ")";
    }
}
