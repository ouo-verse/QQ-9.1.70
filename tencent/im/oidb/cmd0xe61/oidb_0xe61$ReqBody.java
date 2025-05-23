package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe61$ReqBody extends MessageMicro<oidb_0xe61$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_beancurd_cube_info"}, new Object[]{null}, oidb_0xe61$ReqBody.class);
    public final PBRepeatMessageField<oidb_0xe61$BeancurdCubeInfo> rpt_beancurd_cube_info = PBField.initRepeatMessage(oidb_0xe61$BeancurdCubeInfo.class);
}
