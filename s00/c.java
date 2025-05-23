package s00;

import android.content.Context;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.bandwidth.SPBandwidthPredictor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Ls00/c;", "Lcom/tencent/superplayer/api/ISPBandwidthPredictor;", "", "getCurrentPrediction", "getLastBandwidth", "Landroid/content/Context;", "context", "", "start", "stop", "e", "Lcom/tencent/superplayer/api/ISPBandwidthPredictor;", "predictor", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements ISPBandwidthPredictor {

    /* renamed from: d, reason: collision with root package name */
    public static final c f433052d = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ISPBandwidthPredictor predictor;

    static {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(SPBandwidthPredictor.CONFIG_RESET_TIME_SECOND_FOR_XG, IndividuationPlugin.Business_Theme), TuplesKt.to(SPBandwidthPredictor.CONFIG_RESET_TIME_SECOND_FOR_WIFI, "3600"));
        ISPBandwidthPredictor createBandwidthPredictor = SuperPlayerFactory.createBandwidthPredictor(BaseApplication.context, null, null, mapOf);
        Intrinsics.checkNotNullExpressionValue(createBandwidthPredictor, "createBandwidthPredictor\u2026ext, null, null, configs)");
        predictor = createBandwidthPredictor;
    }

    c() {
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public long getCurrentPrediction() {
        return predictor.getCurrentPrediction();
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public long getLastBandwidth() {
        return predictor.getLastBandwidth();
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public void start(Context context) {
        predictor.start(context);
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public void stop(Context context) {
        predictor.stop(context);
    }
}
