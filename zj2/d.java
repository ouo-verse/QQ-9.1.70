package zj2;

import ak2.o;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuType;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.h;
import com.tencent.mobileqq.qqvideoedit.editor.view.BorderView;
import com.tencent.mobileqq.qqvideoedit.event.ImagePageTouchEvent;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import com.tencent.mobileqq.qqvideoedit.utils.i;
import com.tencent.mobileqq.qqvideoedit.view.VideoStickerFrameLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.render.player.IPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 V2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0014J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u001a\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u001a\u0010,\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0016J\u001a\u0010/\u001a\u0004\u0018\u00010 2\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\"H\u0016J\u0012\u00100\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u00101\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 J\u0012\u00102\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u00103\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020>0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010L\u00a8\u0006X"}, d2 = {"Lzj2/d;", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView$b;", "Landroid/view/View;", "view", "", "X9", "", "currentDurationUs", "ba", "Z9", "", "A9", "L9", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "editMode", "J9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "stickerModel", "Landroid/graphics/PointF;", "correctPoint", "T6", "aa", "T", "i", "M0", "", "eventX", "eventY", "o8", "fingerOne", "fingerTwo", "U", ICustomDataEditor.STRING_PARAM_4, "U9", "Z1", "O7", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "k", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout;", "D", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout;", "videoStickerFrameLayout", "Lak2/o;", "E", "Lak2/o;", "videoEditorTextViewModel", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$a;", "editMenuItem", "G", "deleteMenuItem", "H", "Ljava/util/ArrayList;", "popupMenuItems", "I", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "curStickerModel", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "mFakeFeedTopPart", "Landroidx/constraintlayout/widget/ConstraintLayout;", "K", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mFakeFeedInfoPart", "L", "mFakeFeedPersonalInfoPart", "<init>", "()V", "M", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class d extends com.tencent.mobileqq.qqvideoedit.editor.d implements SimpleEventReceiver<SimpleBaseEvent>, BorderView.b {

    /* renamed from: D, reason: from kotlin metadata */
    private VideoStickerFrameLayout videoStickerFrameLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private o videoEditorTextViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private VideoStickerFrameLayout.MenuItem editMenuItem;

    /* renamed from: G, reason: from kotlin metadata */
    private VideoStickerFrameLayout.MenuItem deleteMenuItem;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<VideoStickerFrameLayout.MenuItem> popupMenuItems = new ArrayList<>();

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private VideoStickerModel curStickerModel;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mFakeFeedTopPart;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mFakeFeedInfoPart;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mFakeFeedPersonalInfoPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"zj2/d$b", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$b;", "", "id", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "stickerModel", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements VideoStickerFrameLayout.b {
        b() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.view.VideoStickerFrameLayout.b
        public void a(int id5, @Nullable VideoStickerModel stickerModel) {
            String str;
            VideoStickerFrameLayout videoStickerFrameLayout = null;
            if (id5 != 1) {
                if (id5 == 2) {
                    VideoStickerFrameLayout videoStickerFrameLayout2 = d.this.videoStickerFrameLayout;
                    if (videoStickerFrameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                    } else {
                        videoStickerFrameLayout = videoStickerFrameLayout2;
                    }
                    com.tencent.mobileqq.qqvideoedit.editor.sticker.c.c(videoStickerFrameLayout);
                    d.this.Z1(stickerModel);
                    return;
                }
                if (id5 == 3) {
                    VideoStickerFrameLayout videoStickerFrameLayout3 = d.this.videoStickerFrameLayout;
                    if (videoStickerFrameLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                    } else {
                        videoStickerFrameLayout = videoStickerFrameLayout3;
                    }
                    com.tencent.mobileqq.qqvideoedit.editor.sticker.c.b(videoStickerFrameLayout);
                    d.this.aa(stickerModel);
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            if (stickerModel != null) {
                d dVar = d.this;
                if (stickerModel.type == StickerModel.Type.BOTTOM_FRAME) {
                    VideoStickerModel U9 = dVar.U9(stickerModel);
                    if (U9 != null) {
                        str = U9.id;
                    } else {
                        str = null;
                    }
                    bundle.putString("ARGS_STICKER_ID", str);
                } else {
                    bundle.putString("ARGS_STICKER_ID", stickerModel.id);
                }
                dVar.E9().y2(MenuType.STICKER_TIMELINE, bundle);
                VideoStickerFrameLayout videoStickerFrameLayout4 = dVar.videoStickerFrameLayout;
                if (videoStickerFrameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                } else {
                    videoStickerFrameLayout = videoStickerFrameLayout4;
                }
                com.tencent.mobileqq.qqvideoedit.editor.sticker.c.d(videoStickerFrameLayout, true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"zj2/d$c", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "", "currentDurationUs", "playerDurationUs", "", "onPositionChanged", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements IPlayer.a {
        c() {
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void a(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            IPlayer.a.C9881a.c(this, playerStatus, iPlayer);
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void b(@NotNull IPlayer iPlayer) {
            IPlayer.a.C9881a.a(this, iPlayer);
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            d.this.ba(currentDurationUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int V9(VideoStickerModel videoStickerModel, VideoStickerModel videoStickerModel2) {
        int i3;
        int i16 = 0;
        if (videoStickerModel2 != null) {
            i3 = videoStickerModel2.layerIndex;
        } else {
            i3 = 0;
        }
        if (videoStickerModel != null) {
            i16 = videoStickerModel.layerIndex;
        }
        return i3 - i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int W9(PointF fingerCenter, VideoStickerModel videoStickerModel, VideoStickerModel videoStickerModel2) {
        Intrinsics.checkNotNullParameter(fingerCenter, "$fingerCenter");
        i iVar = i.f276251a;
        return (int) (iVar.g(fingerCenter, new PointF(videoStickerModel.getCenterInView().f275793x, videoStickerModel.getCenterInView().f275794y)) - iVar.g(fingerCenter, new PointF(videoStickerModel2.getCenterInView().f275793x, videoStickerModel2.getCenterInView().f275794y)));
    }

    private final void X9(View view) {
        View findViewById = view.findViewById(R.id.f1171570o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.videoStickerFrameLayout)");
        VideoStickerFrameLayout videoStickerFrameLayout = (VideoStickerFrameLayout) findViewById;
        this.videoStickerFrameLayout = videoStickerFrameLayout;
        VideoStickerFrameLayout videoStickerFrameLayout2 = null;
        if (videoStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
            videoStickerFrameLayout = null;
        }
        videoStickerFrameLayout.c(this.popupMenuItems);
        VideoStickerFrameLayout videoStickerFrameLayout3 = this.videoStickerFrameLayout;
        if (videoStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
        } else {
            videoStickerFrameLayout2 = videoStickerFrameLayout3;
        }
        videoStickerFrameLayout2.setPopupMenuClickListener(new b());
        E9().c2().observe(getHostFragment(), new Observer() { // from class: zj2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.Y9(d.this, (MenuSwitchAction) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(d this$0, MenuSwitchAction menuSwitchAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoStickerFrameLayout videoStickerFrameLayout = this$0.videoStickerFrameLayout;
        if (videoStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
            videoStickerFrameLayout = null;
        }
        videoStickerFrameLayout.b();
    }

    private final void Z9() {
        LinearLayout linearLayout = this.mFakeFeedTopPart;
        if (linearLayout != null && this.mFakeFeedInfoPart != null && this.mFakeFeedPersonalInfoPart != null) {
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(4);
            ConstraintLayout constraintLayout = this.mFakeFeedInfoPart;
            Intrinsics.checkNotNull(constraintLayout);
            constraintLayout.setVisibility(4);
            LinearLayout linearLayout2 = this.mFakeFeedPersonalInfoPart;
            Intrinsics.checkNotNull(linearLayout2);
            linearLayout2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(long currentDurationUs) {
        VideoStickerModel videoStickerModel = this.curStickerModel;
        if (videoStickerModel != null) {
            long j3 = videoStickerModel.startTime;
            if (currentDurationUs < j3 || currentDurationUs > j3 + videoStickerModel.duration) {
                VideoStickerFrameLayout videoStickerFrameLayout = this.videoStickerFrameLayout;
                if (videoStickerFrameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                    videoStickerFrameLayout = null;
                }
                videoStickerFrameLayout.b();
                Z9();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.f88414x0;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void J9(@NotNull VideoEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        if (this.videoStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
        }
        VideoStickerFrameLayout videoStickerFrameLayout = this.videoStickerFrameLayout;
        if (videoStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
            videoStickerFrameLayout = null;
        }
        videoStickerFrameLayout.b();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void L9() {
        IPlayer player;
        super.L9();
        aw F9 = F9();
        if (F9 != null && (player = F9.getPlayer()) != null) {
            player.a(new c());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    public void M0() {
        Z9();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    public void O7(@Nullable VideoStickerModel stickerModel) {
        aa(stickerModel);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    public void T() {
        aw F9 = F9();
        if (F9 != null) {
            F9.T();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    public void T6(@NotNull VideoStickerModel stickerModel, @Nullable PointF correctPoint) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        this.curStickerModel = stickerModel;
        aw F9 = F9();
        if (F9 != null) {
            F9.f0(stickerModel);
        }
        VideoStickerFrameLayout videoStickerFrameLayout = this.videoStickerFrameLayout;
        if (videoStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
            videoStickerFrameLayout = null;
        }
        videoStickerFrameLayout.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0137, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r0, new zj2.c(r2));
     */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoStickerModel U(@NotNull PointF fingerOne, @NotNull PointF fingerTwo) {
        Size size;
        boolean z16;
        long j3;
        boolean z17;
        Map<String, VideoStickerModel> m3;
        List sortedWith;
        Object firstOrNull;
        VideoStickerModel videoStickerModel;
        Map<String, VideoStickerModel> m16;
        Collection<VideoStickerModel> values;
        Object first;
        Map<String, VideoStickerModel> m17;
        IPlayer player;
        Map<String, VideoStickerModel> m18;
        Intrinsics.checkNotNullParameter(fingerOne, "fingerOne");
        Intrinsics.checkNotNullParameter(fingerTwo, "fingerTwo");
        aw F9 = F9();
        if (F9 != null) {
            size = F9.getRenderSize();
        } else {
            size = null;
        }
        if (size == null) {
            return null;
        }
        aw F92 = F9();
        boolean z18 = true;
        if (F92 != null && (m18 = F92.m()) != null && m18.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        aw F93 = F9();
        if (F93 != null && (player = F93.getPlayer()) != null) {
            j3 = player.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        aw F94 = F9();
        if (F94 != null && (m17 = F94.m()) != null && m17.size() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            aw F95 = F9();
            if (F95 != null && (m16 = F95.m()) != null && (values = m16.values()) != null) {
                first = CollectionsKt___CollectionsKt.first(values);
                videoStickerModel = (VideoStickerModel) first;
            } else {
                videoStickerModel = null;
            }
            if (videoStickerModel == null || !videoStickerModel.isVisibleAtCurrentPlayTime(j3)) {
                z18 = false;
            }
            if (!z18) {
                return null;
            }
            return videoStickerModel;
        }
        float f16 = fingerOne.x + fingerTwo.x;
        float f17 = 2;
        float f18 = fingerTwo.y;
        final PointF pointF = new PointF(f16 / f17, (f18 + f18) / f17);
        aw F96 = F9();
        if (F96 == null || (m3 = F96.m()) == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, VideoStickerModel> entry : m3.entrySet()) {
            if (entry.getValue().isVisibleAtCurrentPlayTime(j3)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            VideoStickerModel videoStickerModel2 = (VideoStickerModel) entry2.getValue();
            if (i.f276251a.k(fingerOne.x, fingerOne.y, fingerTwo.x, fingerTwo.y, videoStickerModel2.getLeftTopInView().f275793x, videoStickerModel2.getLeftTopInView().f275794y, videoStickerModel2.getRightBottomInView().f275793x, videoStickerModel2.getRightBottomInView().f275794y)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        Collection values2 = linkedHashMap2.values();
        if (values2 != null && sortedWith != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
            return (VideoStickerModel) firstOrNull;
        }
        return null;
    }

    @Nullable
    public final VideoStickerModel U9(@NotNull VideoStickerModel stickerModel) {
        Map<String, VideoStickerModel> map;
        boolean z16;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        MetaMaterial material = stickerModel.getMaterial();
        Intrinsics.checkNotNull(material);
        Object obj = null;
        if (TextUtils.isEmpty(h.o(material))) {
            return null;
        }
        aw F9 = F9();
        if (F9 != null) {
            map = F9.m();
        } else {
            map = null;
        }
        Intrinsics.checkNotNull(map);
        Iterator<T> it = map.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            VideoStickerModel videoStickerModel = (VideoStickerModel) next;
            MetaMaterial material2 = videoStickerModel.getMaterial();
            Intrinsics.checkNotNull(material2);
            String o16 = h.o(material2);
            MetaMaterial material3 = stickerModel.getMaterial();
            Intrinsics.checkNotNull(material3);
            if (Intrinsics.areEqual(o16, h.o(material3)) && !Intrinsics.areEqual(videoStickerModel.id, stickerModel.id)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (VideoStickerModel) obj;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    public void Z1(@Nullable VideoStickerModel stickerModel) {
        if (E9().getCurMenuType() == MenuType.STICKER_TIMELINE) {
            return;
        }
        this.curStickerModel = stickerModel;
        if (stickerModel != null) {
            o oVar = this.videoEditorTextViewModel;
            VideoStickerFrameLayout videoStickerFrameLayout = null;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorTextViewModel");
                oVar = null;
            }
            if (oVar.p2(stickerModel)) {
                aa(stickerModel);
                VideoStickerFrameLayout videoStickerFrameLayout2 = this.videoStickerFrameLayout;
                if (videoStickerFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                } else {
                    videoStickerFrameLayout = videoStickerFrameLayout2;
                }
                videoStickerFrameLayout.b();
            }
        }
    }

    public void aa(@Nullable VideoStickerModel stickerModel) {
        VideoStickerFrameLayout videoStickerFrameLayout = null;
        this.curStickerModel = null;
        if (stickerModel != null) {
            VideoStickerFrameLayout videoStickerFrameLayout2 = this.videoStickerFrameLayout;
            if (videoStickerFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
            } else {
                videoStickerFrameLayout = videoStickerFrameLayout2;
            }
            videoStickerFrameLayout.b();
            aw F9 = F9();
            if (F9 != null) {
                F9.a0(stickerModel);
            }
            MetaMaterial material = stickerModel.getMaterial();
            if (material != null) {
                C9().b(false, material);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ImagePageTouchEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    public void i() {
        aw F9 = F9();
        if (F9 != null) {
            F9.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ViewModel viewModel = getViewModel(o.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(VideoEditorTextViewModel::class.java)");
        this.videoEditorTextViewModel = (o) viewModel;
        this.editMenuItem = new VideoStickerFrameLayout.MenuItem(2, R.string.f238057iq, R.drawable.oqj);
        this.deleteMenuItem = new VideoStickerFrameLayout.MenuItem(3, R.string.f238047ip, R.drawable.nrk);
        X9(rootView);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    @Nullable
    public Size k() {
        aw F9 = F9();
        if (F9 != null) {
            return F9.k();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
    
        r7 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r7, new zj2.a());
     */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoStickerModel o8(float eventX, float eventY) {
        long j3;
        Map<String, VideoStickerModel> m3;
        List sortedWith;
        Object firstOrNull;
        IPlayer player;
        aw F9 = F9();
        if (F9 != null && (player = F9.getPlayer()) != null) {
            j3 = player.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        aw F92 = F9();
        if (F92 != null && (m3 = F92.m()) != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, VideoStickerModel> entry : m3.entrySet()) {
                if (entry.getValue().isClickInside(eventX, eventY)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (((VideoStickerModel) entry2.getValue()).isVisibleAtCurrentPlayTime(j3)) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            Collection values = linkedHashMap2.values();
            if (values != null && sortedWith != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
                return (VideoStickerModel) firstOrNull;
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof ImagePageTouchEvent) {
            VideoStickerFrameLayout videoStickerFrameLayout = this.videoStickerFrameLayout;
            if (videoStickerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                videoStickerFrameLayout = null;
            }
            videoStickerFrameLayout.b();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    public void s4(@Nullable VideoStickerModel stickerModel) {
        VideoStickerFrameLayout videoStickerFrameLayout = null;
        if (E9().getCurMenuType() == MenuType.STICKER_TIMELINE) {
            if (stickerModel != null) {
                if (stickerModel.type == StickerModel.Type.BOTTOM_FRAME) {
                    VideoStickerModel U9 = U9(stickerModel);
                    if (U9 != null) {
                        broadcastMessage("ARGS_STICKER_ID", U9.id);
                        VideoStickerFrameLayout videoStickerFrameLayout2 = this.videoStickerFrameLayout;
                        if (videoStickerFrameLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                        } else {
                            videoStickerFrameLayout = videoStickerFrameLayout2;
                        }
                        com.tencent.mobileqq.qqvideoedit.editor.sticker.c.a(videoStickerFrameLayout, stickerModel, true);
                        return;
                    }
                    return;
                }
                broadcastMessage("ARGS_STICKER_ID", stickerModel.id);
                VideoStickerFrameLayout videoStickerFrameLayout3 = this.videoStickerFrameLayout;
                if (videoStickerFrameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
                } else {
                    videoStickerFrameLayout = videoStickerFrameLayout3;
                }
                com.tencent.mobileqq.qqvideoedit.editor.sticker.c.a(videoStickerFrameLayout, stickerModel, true);
                return;
            }
            return;
        }
        this.curStickerModel = stickerModel;
        if (stickerModel == null) {
            VideoStickerFrameLayout videoStickerFrameLayout4 = this.videoStickerFrameLayout;
            if (videoStickerFrameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoStickerFrameLayout");
            } else {
                videoStickerFrameLayout = videoStickerFrameLayout4;
            }
            videoStickerFrameLayout.b();
            E9().x2();
            return;
        }
        Z1(stickerModel);
    }
}
