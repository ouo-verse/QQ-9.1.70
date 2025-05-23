package wk3;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.zplan.common.utils.GsonUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lwk3/h;", "", "", "toString", "", "memory", UserInfo.SEX_FEMALE, "c", "()F", "", "gpuBlackList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "apiLevel", "I", "a", "()I", "modelBlackList", "d", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class h {

    @SerializedName("memory")
    private final float memory = 1.0f;

    @SerializedName("GPUBlackList")
    @NotNull
    private final List<String> gpuBlackList = new ArrayList();

    @SerializedName("apiLevel")
    private final int apiLevel = 16;

    @SerializedName("model_black_list")
    @NotNull
    private final List<String> modelBlackList = new ArrayList();

    /* renamed from: a, reason: from getter */
    public final int getApiLevel() {
        return this.apiLevel;
    }

    @NotNull
    public final List<String> b() {
        return this.gpuBlackList;
    }

    /* renamed from: c, reason: from getter */
    public final float getMemory() {
        return this.memory;
    }

    @NotNull
    public final List<String> d() {
        return this.modelBlackList;
    }

    @NotNull
    public String toString() {
        String json = GsonUtil.f385283b.a().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "GsonUtil.gson.toJson(this)");
        return json;
    }
}
