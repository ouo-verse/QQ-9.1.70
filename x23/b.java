package x23;

import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import v23.Node;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JJ\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u0011"}, d2 = {"Lx23/b;", "", "", "serviceName", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "version", "", "Lv23/a;", "dataList", "connectChainKey", "Lorg/json/JSONObject;", "ext", "Lx23/f;", "sample", "", "a", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface b {
    void a(@NotNull String serviceName, @NotNull String setKey, int version, @NotNull List<Node> dataList, @NotNull String connectChainKey, @NotNull JSONObject ext, @Nullable f sample);
}
