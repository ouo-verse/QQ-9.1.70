package sl1;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.feed.nativedetail.fragment.FeedNativeDetailFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.preload.activity.BaseActivityPreloadTask;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import com.tencent.richframework.preload.activity.PredictLayoutLoadStrategy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R6\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u00178\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000f\u0010\u001aR\u001a\u0010!\u001a\u00020\u001c8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010'\u001a\u00020\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010-\u001a\u00020(8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lsl1/a;", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "doAfterActivityCreate", "Ljava/lang/ClassLoader;", "classLoader", "", "activityClassName", "Landroid/content/Intent;", "intent", "", "isTarget", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "getActivityClass", "()Ljava/lang/Class;", "activityClass", "Ljava/util/HashMap;", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "preloadRes", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "c", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "getExecuteMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "executeMode", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "d", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "getPreloadMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "preloadMode", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "e", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getTargetPreLoader", "()Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "targetPreLoader", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends BaseActivityResPreloadTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends Activity> activityClass = QPublicTransFragmentActivity.class;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<PreloadRequest, Integer> preloadRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseActivityPreloadTask.ExecuteMode executeMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseActivityPreloadTask.PreloadMode preloadMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RFWLayoutPreLoader targetPreLoader;

    public a() {
        HashMap<PreloadRequest, Integer> hashMap = new HashMap<>();
        hashMap.put(new PreloadRequest(R.layout.end, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.enl, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.en8, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.f168070en2, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.enn, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.ena, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.exd, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.emw, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.emz, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.emv, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.ep6, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.en6, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.en7, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.en5, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.f168071en3, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.enk, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.eni, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.enj, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.f168072en4, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.e7_, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.exe, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.erf, "", null, 4, null), 1);
        this.preloadRes = hashMap;
        this.executeMode = BaseActivityPreloadTask.ExecuteMode.IDLE;
        this.preloadMode = BaseActivityPreloadTask.PreloadMode.RECYCLE;
        this.targetPreLoader = RFWLayoutPreLoaderFactory.getLayoutLoader(new PredictLayoutLoadStrategy());
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<PreloadRequest, Integer> getPreloadRes() {
        return this.preloadRes;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask, com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public void doAfterActivityCreate(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            qBaseActivity.isEnableDelegateLayoutInflater = true;
            qBaseActivity.isCloneInflaterInSubThread = true;
        }
        super.doAfterActivityCreate(activity);
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @NotNull
    public Class<? extends Activity> getActivityClass() {
        return this.activityClass;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @NotNull
    public BaseActivityPreloadTask.ExecuteMode getExecuteMode() {
        return this.executeMode;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @NotNull
    public BaseActivityPreloadTask.PreloadMode getPreloadMode() {
        return this.preloadMode;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
    @NotNull
    public RFWLayoutPreLoader getTargetPreLoader() {
        return this.targetPreLoader;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public boolean isTarget(@NotNull ClassLoader classLoader, @NotNull String activityClassName, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(activityClassName, "activityClassName");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.setExtrasClassLoader(FeedNativeDetailFragment.class.getClassLoader());
        String stringExtra = intent.getStringExtra("public_fragment_class");
        if (super.isTarget(classLoader, activityClassName, intent) && Intrinsics.areEqual(stringExtra, Reflection.getOrCreateKotlinClass(FeedNativeDetailFragment.class).getQualifiedName())) {
            return true;
        }
        return false;
    }
}
