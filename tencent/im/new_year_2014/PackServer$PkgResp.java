package tencent.im.new_year_2014;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes29.dex */
public final class PackServer$PkgResp extends MessageMicro<PackServer$PkgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 160, 168, 176}, new String[]{"cmdtype", "uin", "errcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "resp_name", "get_new_pack", "query_pack_list", "set_pack_used", "give_pack", "query_pack", "query_user_history", "query_lucky_users", "query_promotion", "query_business", "query_remain_pack", "grab_interval", "report_active_interval", "report_normal_interval"}, new Object[]{0, 0L, 0, "", "", null, null, null, null, null, null, null, null, null, null, 0, 0, 0}, PackServer$PkgResp.class);
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBStringField resp_name = PBField.initString("");
    public PackServer$GetNewPackResp get_new_pack = new MessageMicro<PackServer$GetNewPackResp>() { // from class: tencent.im.new_year_2014.PackServer$GetNewPackResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 80}, new String[]{"promotion_id", "seq", "data", "empty_url", "follow", "is_bingo_limit"}, new Object[]{0, 0, null, "", Boolean.FALSE, 0}, PackServer$GetNewPackResp.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public PackData$Pack data = new PackData$Pack();
        public final PBStringField empty_url = PBField.initString("");
        public final PBBoolField follow = PBField.initBool(false);
        public final PBUInt32Field is_bingo_limit = PBField.initUInt32(0);
    };
    public PackServer$QueryPackListResp query_pack_list = new MessageMicro<PackServer$QueryPackListResp>() { // from class: tencent.im.new_year_2014.PackServer$QueryPackListResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"from_index", "total_count", "count", "data"}, new Object[]{0, 0, 0, null}, PackServer$QueryPackListResp.class);
        public final PBUInt32Field from_index = PBField.initUInt32(0);
        public final PBUInt32Field total_count = PBField.initUInt32(0);
        public final PBUInt32Field count = PBField.initUInt32(0);
        public final PBRepeatMessageField<PackData$Pack> data = PBField.initRepeatMessage(PackData$Pack.class);
    };
    public PackServer$SetPackUsedResp set_pack_used = new MessageMicro<PackServer$SetPackUsedResp>() { // from class: tencent.im.new_year_2014.PackServer$SetPackUsedResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"data", "business"}, new Object[]{ByteStringMicro.EMPTY, 0}, PackServer$SetPackUsedResp.class);
        public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field business = PBField.initUInt32(0);
    };
    public PackServer$GivePackResp give_pack = new MessageMicro<PackServer$GivePackResp>() { // from class: tencent.im.new_year_2014.PackServer$GivePackResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"data", ProtocolDownloaderConstants.HEADER_FRIEND_UIN}, new Object[]{ByteStringMicro.EMPTY, 0L}, PackServer$GivePackResp.class);
        public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    };
    public PackServer$QueryPackResp query_pack = new MessageMicro<PackServer$QueryPackResp>() { // from class: tencent.im.new_year_2014.PackServer$QueryPackResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, PackServer$QueryPackResp.class);
        public PackData$Pack data = new PackData$Pack();
    };
    public PackServer$QueryUserHistoryResp query_user_history = new MessageMicro<PackServer$QueryUserHistoryResp>() { // from class: tencent.im.new_year_2014.PackServer$QueryUserHistoryResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"promotion_id"}, new Object[]{0}, PackServer$QueryUserHistoryResp.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    };
    public PackServer$QueryLuckyUsersResp query_lucky_users = new MessageMicro<PackServer$QueryLuckyUsersResp>() { // from class: tencent.im.new_year_2014.PackServer$QueryLuckyUsersResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{ByteStringMicro.EMPTY}, PackServer$QueryLuckyUsersResp.class);
        public final PBBytesField list = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public PackServer$QueryPromotionResp query_promotion = new MessageMicro<PackServer$QueryPromotionResp>() { // from class: tencent.im.new_year_2014.PackServer$QueryPromotionResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"promotion_id"}, new Object[]{0}, PackServer$QueryPromotionResp.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    };
    public PackServer$QueryBusinessResp query_business = new MessageMicro<PackServer$QueryBusinessResp>() { // from class: tencent.im.new_year_2014.PackServer$QueryBusinessResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"business", "pack"}, new Object[]{0, null}, PackServer$QueryBusinessResp.class);
        public final PBUInt32Field business = PBField.initUInt32(0);
        public PackData$Pack pack = new PackData$Pack();
    };
    public PackServer$QueryRemainPackResp query_remain_pack = new MessageMicro<PackServer$QueryRemainPackResp>() { // from class: tencent.im.new_year_2014.PackServer$QueryRemainPackResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"promotion_id", "pack_count", "interval_time"}, new Object[]{0, 0, 0}, PackServer$QueryRemainPackResp.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
        public final PBUInt32Field pack_count = PBField.initUInt32(0);
        public final PBUInt32Field interval_time = PBField.initUInt32(0);
    };
    public final PBUInt32Field grab_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_active_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_normal_interval = PBField.initUInt32(0);
}
