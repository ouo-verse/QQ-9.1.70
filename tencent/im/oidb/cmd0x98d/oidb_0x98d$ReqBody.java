package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x98d$ReqBody extends MessageMicro<oidb_0x98d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"y_list_req", "z_list_req", "get_req"}, new Object[]{null, null, null}, oidb_0x98d$ReqBody.class);
    public oidb_0x98d$YListReq y_list_req = new MessageMicro<oidb_0x98d$YListReq>() { // from class: tencent.im.oidb.cmd0x98d.oidb_0x98d$YListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "start", "limit"}, new Object[]{0L, 0, 0}, oidb_0x98d$YListReq.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt32Field start = PBField.initUInt32(0);
        public final PBUInt32Field limit = PBField.initUInt32(0);
    };
    public oidb_0x98d$ZListReq z_list_req = new MessageMicro<oidb_0x98d$ZListReq>() { // from class: tencent.im.oidb.cmd0x98d.oidb_0x98d$ZListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_code"}, new Object[]{0L}, oidb_0x98d$ZListReq.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
    };
    public oidb_0x98d$GetReq get_req = new MessageMicro<oidb_0x98d$GetReq>() { // from class: tencent.im.oidb.cmd0x98d.oidb_0x98d$GetReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QzoneCameraConst.Tag.ARG_PARAM_EFFECT_ID}, new Object[]{0}, oidb_0x98d$GetReq.class);
        public final PBUInt32Field effect_id = PBField.initUInt32(0);
    };
}
