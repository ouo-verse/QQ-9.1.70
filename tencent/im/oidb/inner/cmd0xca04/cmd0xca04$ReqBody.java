package tencent.im.oidb.inner.cmd0xca04;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca04$ReqBody extends MessageMicro<cmd0xca04$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint32_timestamp", "rpt_uint32_appids", "msg_app_info", "rpt_uint32_add_appids", "rpt_uint32_del_appids"}, new Object[]{0, 0, null, 0, 0}, cmd0xca04$ReqBody.class);
    public cmd0xca04$AppInfo msg_app_info;
    public final PBRepeatField<Integer> rpt_uint32_add_appids;
    public final PBRepeatField<Integer> rpt_uint32_appids;
    public final PBRepeatField<Integer> rpt_uint32_del_appids;
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);

    public cmd0xca04$ReqBody() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_appids = PBField.initRepeat(pBUInt32Field);
        this.msg_app_info = new cmd0xca04$AppInfo();
        this.rpt_uint32_add_appids = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_del_appids = PBField.initRepeat(pBUInt32Field);
    }
}
