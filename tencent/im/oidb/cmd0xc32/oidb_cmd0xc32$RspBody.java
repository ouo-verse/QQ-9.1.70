package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc32$RspBody extends MessageMicro<oidb_cmd0xc32$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_set_rsp_body", "msg_get_rsp_body", "msg_check_rsp_body"}, new Object[]{null, null, null}, oidb_cmd0xc32$RspBody.class);
    public oidb_cmd0xc32$SetVisibleListRspBody msg_set_rsp_body = new MessageMicro<oidb_cmd0xc32$SetVisibleListRspBody>() { // from class: tencent.im.oidb.cmd0xc32.oidb_cmd0xc32$SetVisibleListRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xc32$SetVisibleListRspBody.class);
    };
    public oidb_cmd0xc32$GetVisibleListRspBody msg_get_rsp_body = new MessageMicro<oidb_cmd0xc32$GetVisibleListRspBody>() { // from class: tencent.im.oidb.cmd0xc32.oidb_cmd0xc32$GetVisibleListRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_feeds_id", "rpt_uint64_visible_uins", "uint32_total_count", "uint32_next_ix", "uint32_is_end", "uint64_feeds_author"}, new Object[]{0L, 0L, 0, 0, 0, 0L}, oidb_cmd0xc32$GetVisibleListRspBody.class);
        public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
        public final PBRepeatField<Long> rpt_uint64_visible_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_next_ix = PBField.initUInt32(0);
        public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
        public final PBUInt64Field uint64_feeds_author = PBField.initUInt64(0);
    };
    public oidb_cmd0xc32$CheckVisibilityRspBody msg_check_rsp_body = new MessageMicro<oidb_cmd0xc32$CheckVisibilityRspBody>() { // from class: tencent.im.oidb.cmd0xc32.oidb_cmd0xc32$CheckVisibilityRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_triads"}, new Object[]{null}, oidb_cmd0xc32$CheckVisibilityRspBody.class);
        public final PBRepeatMessageField<oidb_cmd0xc32$CheckTriad> rpt_triads = PBField.initRepeatMessage(oidb_cmd0xc32$CheckTriad.class);
    };
}
