package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe61$BeancurdCubeInfoResult extends MessageMicro<oidb_0xe61$BeancurdCubeInfoResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "beancurdCubeInfo"}, new Object[]{0, null}, oidb_0xe61$BeancurdCubeInfoResult.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public oidb_0xe61$BeancurdCubeInfo beancurdCubeInfo = new oidb_0xe61$BeancurdCubeInfo();
}
