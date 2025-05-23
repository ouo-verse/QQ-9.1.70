package sa2;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.NearbyProFeedsBasePart;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.StatusFeedData;
import com.tencent.mobileqq.nearbypro.feedscheck.widgets.FeedBubble;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lsa2/f;", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/NearbyProFeedsBasePart;", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/h;", "statusFeedData", "", "M9", "", "", "", "likeInfoMap", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedBubble;", tl.h.F, "Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedBubble;", "bubbleView", "", "i", "I", "listSelectPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/h;", "curStatusFeedData", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f extends NearbyProFeedsBasePart {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FeedBubble bubbleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int listSelectPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StatusFeedData curStatusFeedData;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
            } else {
                this$0.E9().P1(this$0.listSelectPosition);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(f this$0, Map it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.L9(it);
    }

    private final void L9(Map<String, Boolean> likeInfoMap) {
        StatusFeedData statusFeedData = this.curStatusFeedData;
        if (statusFeedData != null) {
            Intrinsics.checkNotNull(statusFeedData);
            if (statusFeedData.getStatusFeed() != null) {
                StatusFeedData statusFeedData2 = this.curStatusFeedData;
                Intrinsics.checkNotNull(statusFeedData2);
                op4.i statusFeed = statusFeedData2.getStatusFeed();
                Intrinsics.checkNotNull(statusFeed);
                Boolean bool = likeInfoMap.get(statusFeed.f423351a);
                if (bool != null) {
                    boolean booleanValue = bool.booleanValue();
                    FeedBubble feedBubble = this.bubbleView;
                    if (feedBubble == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bubbleView");
                        feedBubble = null;
                    }
                    feedBubble.setILikeIcon(booleanValue);
                }
            }
        }
    }

    private final void M9(StatusFeedData statusFeedData) {
        this.curStatusFeedData = statusFeedData;
        FeedBubble feedBubble = this.bubbleView;
        if (feedBubble == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleView");
            feedBubble = null;
        }
        feedBubble.setBubbleData(statusFeedData, z9());
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "LIST_SELECT_ITEM_POSITION")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Int");
            this.listSelectPosition = ((Integer) args).intValue();
            List<StatusFeedData> value = E9().Z1().getValue();
            if (value != null) {
                M9(value.get(this.listSelectPosition));
                Map<String, Boolean> it12 = E9().X1().getValue();
                if (it12 != null) {
                    Intrinsics.checkNotNullExpressionValue(it12, "it1");
                    L9(it12);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.zon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.nearbypro_feedbubble)");
        FeedBubble feedBubble = (FeedBubble) findViewById;
        this.bubbleView = feedBubble;
        if (feedBubble == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleView");
            feedBubble = null;
        }
        feedBubble.setFeedILikeClickListener(new View.OnClickListener() { // from class: sa2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.J9(f.this, view);
            }
        });
        E9().X1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: sa2.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.K9(f.this, (Map) obj);
            }
        });
    }
}
