package tencent.im.oidb.cmd0xed4;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xed4$ReqBody extends MessageMicro<oidb_cmd0xed4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{PublicAccountMessageUtilImpl.META_NAME, "query_req", "present_req", "reward_req", "content_coin_check_req", "content_coin_num_query_req", "security_info"}, new Object[]{null, null, null, null, null, null, null}, oidb_cmd0xed4$ReqBody.class);
    public oidb_cmd0xed4$MetaData meta = new MessageMicro<oidb_cmd0xed4$MetaData>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$MetaData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "timestamp"}, new Object[]{1, 0L}, oidb_cmd0xed4$MetaData.class);
        public final PBEnumField type = PBField.initEnum(1);
        public final PBUInt64Field timestamp = PBField.initUInt64(0);
    };
    public oidb_cmd0xed4$CoinQueryReq query_req = new MessageMicro<oidb_cmd0xed4$CoinQueryReq>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$CoinQueryReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, oidb_cmd0xed4$CoinQueryReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    };
    public oidb_cmd0xed4$CoinPresentReq present_req = new MessageMicro<oidb_cmd0xed4$CoinPresentReq>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$CoinPresentReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, oidb_cmd0xed4$CoinPresentReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    };
    public oidb_cmd0xed4$CoinRewardReq reward_req = new MessageMicro<oidb_cmd0xed4$CoinRewardReq>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$CoinRewardReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", "coin_cnt", "rowkey"}, new Object[]{0L, 0L, 0, ""}, oidb_cmd0xed4$CoinRewardReq.class);
        public final PBUInt64Field from_uin = PBField.initUInt64(0);
        public final PBUInt64Field to_uin = PBField.initUInt64(0);
        public final PBUInt32Field coin_cnt = PBField.initUInt32(0);
        public final PBStringField rowkey = PBField.initString("");
    };
    public oidb_cmd0xed4$ContentCoinCheckReq content_coin_check_req = new MessageMicro<oidb_cmd0xed4$ContentCoinCheckReq>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$ContentCoinCheckReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "rowkey"}, new Object[]{0L, ""}, oidb_cmd0xed4$ContentCoinCheckReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField rowkey = PBField.initString("");
    };
    public oidb_cmd0xed4$ContentCoinNumQueryReq content_coin_num_query_req = new MessageMicro<oidb_cmd0xed4$ContentCoinNumQueryReq>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$ContentCoinNumQueryReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rowkey"}, new Object[]{""}, oidb_cmd0xed4$ContentCoinNumQueryReq.class);
        public final PBStringField rowkey = PBField.initString("");
    };
    public oidb_cmd0xed4$SecurityInfo security_info = new MessageMicro<oidb_cmd0xed4$SecurityInfo>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$SecurityInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58}, new String[]{"nickname", "device_id", "ip", "terminal_id", "os_type", "app_version", "extra"}, new Object[]{"", "", "", "", 0, "", null}, oidb_cmd0xed4$SecurityInfo.class);
        public final PBStringField nickname = PBField.initString("");
        public final PBStringField device_id = PBField.initString("");

        /* renamed from: ip, reason: collision with root package name */
        public final PBStringField f435999ip = PBField.initString("");
        public final PBStringField terminal_id = PBField.initString("");
        public final PBInt32Field os_type = PBField.initInt32(0);
        public final PBStringField app_version = PBField.initString("");
        public final PBRepeatMessageField<oidb_cmd0xed4$ExtraInfo> extra = PBField.initRepeatMessage(oidb_cmd0xed4$ExtraInfo.class);
    };
}
