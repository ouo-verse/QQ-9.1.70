package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.rmonitor.custom.ICustomDataEditor;

/* loaded from: classes29.dex */
public final class PackServer$PkgReq extends MessageMicro<PackServer$PkgReq> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: a8, reason: collision with root package name */
    public final PBBytesField f435960a8;
    public final PBUInt32Field appid;
    public final PBUInt32Field ctime;
    public final PBUInt32Field from_id;
    public final PBUInt32Field net_type;
    public final PBBytesField skey;
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public PackServer$GetNewPackReq get_new_pack = new MessageMicro<PackServer$GetNewPackReq>() { // from class: tencent.im.new_year_2014.PackServer$GetNewPackReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 160}, new String[]{"promotion_id", "seq", "signature", "group_id", "group_type", "business"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, 0, 0}, PackServer$GetNewPackReq.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field group_id = PBField.initUInt32(0);
        public final PBUInt32Field group_type = PBField.initUInt32(0);
        public final PBUInt32Field business = PBField.initUInt32(0);
    };
    public PackServer$QueryPackListReq query_pack_list = new MessageMicro<PackServer$QueryPackListReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryPackListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"from_index", "count", "type"}, new Object[]{0, 0, 0}, PackServer$QueryPackListReq.class);
        public final PBUInt32Field from_index = PBField.initUInt32(0);
        public final PBInt32Field count = PBField.initInt32(0);
        public final PBInt32Field type = PBField.initInt32(0);
    };
    public PackServer$SetPackUsedReq set_pack_used = new MessageMicro<PackServer$SetPackUsedReq>() { // from class: tencent.im.new_year_2014.PackServer$SetPackUsedReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"pack_id", "external"}, new Object[]{ByteStringMicro.EMPTY, Boolean.FALSE}, PackServer$SetPackUsedReq.class);
        public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField external = PBField.initBool(false);
    };
    public PackServer$GivePackReq give_pack = new MessageMicro<PackServer$GivePackReq>() { // from class: tencent.im.new_year_2014.PackServer$GivePackReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"pack_id", ProtocolDownloaderConstants.HEADER_FRIEND_UIN}, new Object[]{ByteStringMicro.EMPTY, 0L}, PackServer$GivePackReq.class);
        public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    };
    public PackServer$QueryPackReq query_pack = new MessageMicro<PackServer$QueryPackReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryPackReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pack_id"}, new Object[]{ByteStringMicro.EMPTY}, PackServer$QueryPackReq.class);
        public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public PackServer$QueryUserHistoryReq query_user_history = new MessageMicro<PackServer$QueryUserHistoryReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryUserHistoryReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"promotion_id"}, new Object[]{0}, PackServer$QueryUserHistoryReq.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    };
    public PackServer$QueryLuckyUsersReq query_lucky_users = new MessageMicro<PackServer$QueryLuckyUsersReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryLuckyUsersReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"count"}, new Object[]{0}, PackServer$QueryLuckyUsersReq.class);
        public final PBUInt32Field count = PBField.initUInt32(0);
    };
    public PackServer$QueryPromotionReq query_promotion = new MessageMicro<PackServer$QueryPromotionReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryPromotionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"promotion_id"}, new Object[]{0}, PackServer$QueryPromotionReq.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    };
    public PackServer$QueryBusinessReq query_business = new MessageMicro<PackServer$QueryBusinessReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryBusinessReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"business"}, new Object[]{0}, PackServer$QueryBusinessReq.class);
        public final PBUInt32Field business = PBField.initUInt32(0);
    };
    public PackServer$QueryRemainPackReq query_remain_pack = new MessageMicro<PackServer$QueryRemainPackReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryRemainPackReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"promotion_id"}, new Object[]{0}, PackServer$QueryRemainPackReq.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    };
    public PackServer$QueryReloadCounterReq query_reload_counter = new MessageMicro<PackServer$QueryReloadCounterReq>() { // from class: tencent.im.new_year_2014.PackServer$QueryReloadCounterReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"now"}, new Object[]{0}, PackServer$QueryReloadCounterReq.class);
        public final PBUInt32Field now = PBField.initUInt32(0);
    };

    static {
        String[] strArr = {"cmdtype", "uin", "get_new_pack", "query_pack_list", "set_pack_used", "give_pack", "query_pack", "query_user_history", "query_lucky_users", "query_promotion", "query_business", "query_remain_pack", "query_reload_counter", "skey", ICustomDataEditor.STRING_ARRAY_PARAM_8, "appid", "from_id", "net_type", "ctime"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 162, 170, 176, 184, 192, 200}, strArr, new Object[]{0, 0L, null, null, null, null, null, null, null, null, null, null, null, byteStringMicro, byteStringMicro, 0, 0, 0, 0}, PackServer$PkgReq.class);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [tencent.im.new_year_2014.PackServer$QueryPromotionReq] */
    /* JADX WARN: Type inference failed for: r1v11, types: [tencent.im.new_year_2014.PackServer$QueryBusinessReq] */
    /* JADX WARN: Type inference failed for: r1v12, types: [tencent.im.new_year_2014.PackServer$QueryRemainPackReq] */
    /* JADX WARN: Type inference failed for: r1v13, types: [tencent.im.new_year_2014.PackServer$QueryReloadCounterReq] */
    /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.new_year_2014.PackServer$GetNewPackReq] */
    /* JADX WARN: Type inference failed for: r1v4, types: [tencent.im.new_year_2014.PackServer$QueryPackListReq] */
    /* JADX WARN: Type inference failed for: r1v5, types: [tencent.im.new_year_2014.PackServer$SetPackUsedReq] */
    /* JADX WARN: Type inference failed for: r1v6, types: [tencent.im.new_year_2014.PackServer$GivePackReq] */
    /* JADX WARN: Type inference failed for: r1v7, types: [tencent.im.new_year_2014.PackServer$QueryPackReq] */
    /* JADX WARN: Type inference failed for: r1v8, types: [tencent.im.new_year_2014.PackServer$QueryUserHistoryReq] */
    /* JADX WARN: Type inference failed for: r1v9, types: [tencent.im.new_year_2014.PackServer$QueryLuckyUsersReq] */
    public PackServer$PkgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.skey = PBField.initBytes(byteStringMicro);
        this.f435960a8 = PBField.initBytes(byteStringMicro);
        this.appid = PBField.initUInt32(0);
        this.from_id = PBField.initUInt32(0);
        this.net_type = PBField.initUInt32(0);
        this.ctime = PBField.initUInt32(0);
    }
}
