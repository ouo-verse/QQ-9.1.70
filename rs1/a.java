package rs1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import e12.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001f\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lrs1/a;", "Landroidx/lifecycle/ViewModel;", "", "L1", "S1", "Q1", "init", "T1", "", "R1", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "i", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "toExpandView", BdhLogUtil.LogTag.Tag_Conn, "N1", "toCollapseView", "D", "P1", "toLandView", "Le12/e;", "", "E", "Le12/e;", "M1", "()Le12/e;", "shareUserId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private y mAudioRoomObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> toExpandView = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> toCollapseView = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> toLandView = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e<String> shareUserId = new e<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"rs1/a$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "userId", "", "available", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void z(@Nullable String userId, boolean available) {
            QLog.i("QGMC.GuildMediaChatViewModel", 1, "[onUserVideoAvailable] " + userId + ", " + available);
            if (!available || userId == null) {
                userId = "";
            }
            a.this.M1().postValue(userId);
        }
    }

    private final void L1() {
        this.mAudioRoomObserver = new b();
        AudioNotifyHelper l06 = j.a().l0();
        y yVar = this.mAudioRoomObserver;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioRoomObserver");
            yVar = null;
        }
        l06.b(yVar);
    }

    private final void Q1() {
        String str;
        p h16 = j.c().getUserInfoList().h();
        if (h16 != null) {
            str = h16.f228093a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.shareUserId.postValue(str);
    }

    private final void S1() {
        if (this.mAudioRoomObserver != null) {
            AudioNotifyHelper l06 = j.a().l0();
            y yVar = this.mAudioRoomObserver;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioRoomObserver");
                yVar = null;
            }
            l06.B(yVar);
        }
    }

    @NotNull
    public final e<String> M1() {
        return this.shareUserId;
    }

    @NotNull
    public final MutableLiveData<Boolean> N1() {
        return this.toCollapseView;
    }

    @NotNull
    public final MutableLiveData<Boolean> O1() {
        return this.toExpandView;
    }

    @NotNull
    public final MutableLiveData<Boolean> P1() {
        return this.toLandView;
    }

    public final boolean R1() {
        String str = j.c().getSelfUserInfo().f228093a;
        p h16 = j.c().getUserInfoList().h();
        if (h16 != null && Intrinsics.areEqual(h16.f228093a, str)) {
            return true;
        }
        return false;
    }

    public final void T1() {
        S1();
    }

    public final void init() {
        L1();
        Q1();
    }
}
