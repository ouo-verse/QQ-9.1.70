package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$ElemFlags2 extends MessageMicro<im_msg_body$ElemFlags2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 88, 96, 106, 112}, new String[]{"uint32_color_text_id", "uint64_msg_id", "uint32_whisper_session_id", "uint32_ptt_change_bit", "uint32_vip_status", "uint32_compatible_id", "rpt_insts", "uint32_msg_rpt_cnt", "src_inst", "uint32_longtitude", "uint32_latitude", "uint32_custom_font", "pc_support_def", "uint32_crm_flags"}, new Object[]{0, 0L, 0, 0, 0, 0, null, 0, null, 0, 0, 0, null, 0}, im_msg_body$ElemFlags2.class);
    public final PBUInt32Field uint32_color_text_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_whisper_session_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_change_bit = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_compatible_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<Inst> rpt_insts = PBField.initRepeatMessage(Inst.class);
    public final PBUInt32Field uint32_msg_rpt_cnt = PBField.initUInt32(0);
    public Inst src_inst = new Inst();
    public final PBUInt32Field uint32_longtitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_custom_font = PBField.initUInt32(0);
    public im_msg_body$PcSupportDef pc_support_def = new MessageMicro<im_msg_body$PcSupportDef>() { // from class: tencent.im.msg.im_msg_body$PcSupportDef
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint32_pc_ptl_begin", "uint32_pc_ptl_end", "uint32_mac_ptl_begin", "uint32_mac_ptl_end", "rpt_ptls_support", "rpt_ptls_not_support"}, new Object[]{0, 0, 0, 0, 0, 0}, im_msg_body$PcSupportDef.class);
        public final PBRepeatField<Integer> rpt_ptls_not_support;
        public final PBRepeatField<Integer> rpt_ptls_support;
        public final PBUInt32Field uint32_pc_ptl_begin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pc_ptl_end = PBField.initUInt32(0);
        public final PBUInt32Field uint32_mac_ptl_begin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_mac_ptl_end = PBField.initUInt32(0);

        {
            PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
            this.rpt_ptls_support = PBField.initRepeat(pBUInt32Field);
            this.rpt_ptls_not_support = PBField.initRepeat(pBUInt32Field);
        }
    };
    public final PBUInt32Field uint32_crm_flags = PBField.initUInt32(0);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Inst extends MessageMicro<Inst> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_app_id", "uint32_inst_id"}, new Object[]{0, 0}, Inst.class);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
    }
}
