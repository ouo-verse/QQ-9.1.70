package xg4;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lxg4/b;", "", "", "b", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/emoticonview/api/IEmoticonMainPanelService$PanelBuilder;", "c", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "a", "Lcom/tencent/mobileqq/emoticonview/api/IEmoticonMainPanelService$PanelBuilder;", "mPanelBuilder", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "mEmoApp", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IEmoticonMainPanelService.PanelBuilder mPanelBuilder;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IEmoticonMainPanelApp mEmoApp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"xg4/b$b", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xg4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11547b implements EmoticonCallback {
        C11547b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"xg4/b$c", "Lcom/tencent/mobileqq/emoticonview/EmoticonListProvider;", "", "hasBigEmotion", "onlySysAndEmoji", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelInfo;", "getEmotionPanelInfo", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements EmoticonListProvider {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
        @NotNull
        public List<EmotionPanelInfo> getEmotionPanelInfo(boolean hasBigEmotion, boolean onlySysAndEmoji) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
            arrayList.add(new EmotionPanelInfo(4, 4, null));
            arrayList.add(new EmotionPanelInfo(11, 4, null));
            return arrayList;
        }
    }

    private final void b() {
        if (this.mEmoApp == null) {
            IEmoticonMainPanelApp iEmoticonMainPanelApp = null;
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime(null)");
            c(waitAppRuntime);
            IEmoticonMainPanelService.PanelBuilder panelBuilder = this.mPanelBuilder;
            if (panelBuilder != null) {
                iEmoticonMainPanelApp = panelBuilder.getEmoticonMainPanelApp();
            }
            this.mEmoApp = iEmoticonMainPanelApp;
        }
    }

    private final IEmoticonMainPanelService.PanelBuilder c(AppRuntime appRuntime) {
        IEmoticonMainPanelService.PanelBuilder panelBuilder = this.mPanelBuilder;
        if (panelBuilder != null) {
            Intrinsics.checkNotNull(panelBuilder);
            return panelBuilder;
        }
        IEmoticonMainPanelService.PanelBuilder newBuilder = ((IEmoticonMainPanelService) appRuntime.getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(BaseApplication.context, 100004);
        this.mPanelBuilder = newBuilder;
        if (newBuilder != null) {
            newBuilder.setStyleChange(true);
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder2 = this.mPanelBuilder;
        if (panelBuilder2 != null) {
            panelBuilder2.setCallBack(new C11547b());
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder3 = this.mPanelBuilder;
        if (panelBuilder3 != null) {
            panelBuilder3.setEmoticonListProvider(new c());
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder4 = this.mPanelBuilder;
        if (panelBuilder4 != null) {
            panelBuilder4.setDisableMoreEmotionButton(true);
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder5 = this.mPanelBuilder;
        Intrinsics.checkNotNull(panelBuilder5);
        return panelBuilder5;
    }

    @NotNull
    public final List<EmotionPanelData> a() {
        b();
        List<EmotionPanelData> emoticonList = ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).getEmoticonList(this.mEmoApp, 7, 5);
        Intrinsics.checkNotNullExpressionValue(emoticonList, "api(IEmoticonInfoService\u2026ts.BUSINESS_ID_TIMI_GAME)");
        com.tencent.timi.game.utils.l.i("QQEmoDataHelper_", "getSystemAndEmojiData size:" + emoticonList.size());
        return emoticonList;
    }
}
