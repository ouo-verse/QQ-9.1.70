package tencent.im.oidb;

import appoint.define.appoint_define$AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5fa$ReqBody extends MessageMicro<cmd0x5fa$ReqBody> {
    public static final int RPT_APPOINT_IDS_FIELD_NUMBER = 1;
    public static final int UINT32_GET_REFER_REC_FIELD_NUMBER = 3;
    public static final int UINT32_REFER_IDX_FIELD_NUMBER = 2;
    public static final int UINT32_REQ_NEXT_COUNT_FIELD_NUMBER = 4;
    public static final int UINT32_REQ_PREV_COUNT_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"rpt_appoint_ids", "uint32_refer_idx", "uint32_get_refer_rec", "uint32_req_next_count", "uint32_req_prev_count"}, new Object[]{null, 0, 0, 0, 0}, cmd0x5fa$ReqBody.class);
    public appoint_define$AppointID rpt_appoint_ids = new appoint_define$AppointID();
    public final PBUInt32Field uint32_refer_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_refer_rec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_next_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_prev_count = PBField.initUInt32(0);
}
