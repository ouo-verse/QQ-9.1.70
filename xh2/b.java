package xh2;

import com.tencent.mobileqq.qqguildsdk.data.Desc;
import com.tencent.mobileqq.qqguildsdk.data.GProRolePermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.ek;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001JF\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nH&\u00a8\u0006\u0011"}, d2 = {"Lxh2/b;", "", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/GProRolePermission;", "allowPermission", "", "Lcom/tencent/mobileqq/qqguildsdk/data/bv;", "desc", "Lcom/tencent/mobileqq/qqguildsdk/data/ek;", "permissionCategories", "", "a", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {
    void a(int result, @NotNull String errMsg, @Nullable IGProGuildRoleInfo roleInfo, @NotNull GProRolePermission allowPermission, @NotNull List<Desc> desc, @NotNull List<? extends ek> permissionCategories);
}
