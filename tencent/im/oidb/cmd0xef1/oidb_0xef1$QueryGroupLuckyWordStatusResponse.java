package tencent.im.oidb.cmd0xef1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef1$QueryGroupLuckyWordStatusResponse extends MessageMicro<oidb_0xef1$QueryGroupLuckyWordStatusResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"wording", "status", "remain_times"}, new Object[]{"", 0, 0}, oidb_0xef1$QueryGroupLuckyWordStatusResponse.class);
    public final PBStringField wording = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBInt32Field remain_times = PBField.initInt32(0);
}
