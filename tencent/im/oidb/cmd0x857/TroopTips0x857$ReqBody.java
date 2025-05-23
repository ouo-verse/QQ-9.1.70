package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$ReqBody extends MessageMicro<TroopTips0x857$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_ex_info;
    public final PBBytesField opt_bytes_msg;
    public final PBUInt32Field opt_msg_opt;
    public final PBBoolField opt_push_mode;
    public final PBUInt64Field opt_store_time;
    public final PBUInt32Field opt_sysdb_flag;
    public final PBUInt32Field opt_uint32_busi_type;
    public final PBUInt32Field opt_uint32_featureid;
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_memberuins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field opt_uint32_offline = PBField.initUInt32(0);
    public TroopTips0x857$InstCtrl msg_inst_ctrl = new MessageMicro<TroopTips0x857$InstCtrl>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$InstCtrl
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst"}, new Object[]{null, null, null}, TroopTips0x857$InstCtrl.class);
        public final PBRepeatMessageField<TroopTips0x857$InstInfo> rpt_msg_send_to_inst = PBField.initRepeatMessage(TroopTips0x857$InstInfo.class);
        public final PBRepeatMessageField<TroopTips0x857$InstInfo> rpt_msg_exclude_inst = PBField.initRepeatMessage(TroopTips0x857$InstInfo.class);
        public TroopTips0x857$InstInfo msg_from_inst = new MessageMicro<TroopTips0x857$InstInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$InstInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 72}, new String[]{"uint32_apppid", "uint32_instid", "uint32_platform", "uint32_open_appid", "uint32_productid", "uint32_sso_bid", "bytes_guid", "uint32_ver_min", "uint32_ver_max"}, new Object[]{0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0, 0}, TroopTips0x857$InstInfo.class);
            public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
            public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
            public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
            public final PBUInt32Field uint32_open_appid = PBField.initUInt32(0);
            public final PBUInt32Field uint32_productid = PBField.initUInt32(0);
            public final PBUInt32Field uint32_sso_bid = PBField.initUInt32(0);
            public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_ver_min = PBField.initUInt32(0);
            public final PBUInt32Field uint32_ver_max = PBField.initUInt32(0);
        };
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64, 72, 82, 88, 96}, new String[]{"opt_uint64_group_code", "rpt_uint64_memberuins", "opt_uint32_offline", "msg_inst_ctrl", "opt_bytes_msg", "opt_uint32_busi_type", "opt_sysdb_flag", "opt_uint32_featureid", "opt_push_mode", "opt_bytes_ex_info", "opt_msg_opt", "opt_store_time"}, new Object[]{0L, 0L, 0, null, byteStringMicro, 0, 0, 0, Boolean.FALSE, byteStringMicro, 0, 0L}, TroopTips0x857$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [tencent.im.oidb.cmd0x857.TroopTips0x857$InstCtrl] */
    public TroopTips0x857$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.opt_bytes_msg = PBField.initBytes(byteStringMicro);
        this.opt_uint32_busi_type = PBField.initUInt32(0);
        this.opt_sysdb_flag = PBField.initUInt32(0);
        this.opt_uint32_featureid = PBField.initUInt32(0);
        this.opt_push_mode = PBField.initBool(false);
        this.opt_bytes_ex_info = PBField.initBytes(byteStringMicro);
        this.opt_msg_opt = PBField.initUInt32(0);
        this.opt_store_time = PBField.initUInt64(0L);
    }
}
