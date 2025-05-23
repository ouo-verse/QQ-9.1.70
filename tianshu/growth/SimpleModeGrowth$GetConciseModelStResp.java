package tianshu.growth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SimpleModeGrowth$GetConciseModelStResp extends MessageMicro<SimpleModeGrowth$GetConciseModelStResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{MessageRoamJsPlugin.USERTYPE, "concise_model", "now_concise_model"}, new Object[]{0, 0, 0}, SimpleModeGrowth$GetConciseModelStResp.class);
    public final PBEnumField userType = PBField.initEnum(0);
    public final PBInt32Field concise_model = PBField.initInt32(0);
    public final PBInt32Field now_concise_model = PBField.initInt32(0);
}
