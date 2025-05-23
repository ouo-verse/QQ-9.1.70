package xh2;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001JB\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&\u00a8\u0006\r"}, d2 = {"Lxh2/a;", "", "", "result", "", "errMsg", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleList", "levelRoleList", "myRoles", "", "a", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a {
    void a(int result, @NotNull String errMsg, @NotNull List<? extends IGProGuildRoleInfo> roleList, @NotNull List<? extends IGProGuildRoleInfo> levelRoleList, @NotNull List<String> myRoles);
}
