package trpc.qlive.trpc_user_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcUserInfoSvrOuterClass$GetUserInfoRsp extends MessageMicro<TrpcUserInfoSvrOuterClass$GetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"user_info", "follow_info", "medal_info", "balance", "fans_group_info"}, new Object[]{null, null, null, 0L, null}, TrpcUserInfoSvrOuterClass$GetUserInfoRsp.class);
    public TrpcUserInfoSvrOuterClass$UserBaseInfo user_info = new MessageMicro<TrpcUserInfoSvrOuterClass$UserBaseInfo>() { // from class: trpc.qlive.trpc_user_info_svr.TrpcUserInfoSvrOuterClass$UserBaseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 58, 64}, new String[]{"uid", "nick", "sex", "logo", IProfileProtocolConst.KEY_HOMETOWN, "explicit_uid", "signature", "qq"}, new Object[]{0L, "", 0, "", "", 0L, "", 0L}, TrpcUserInfoSvrOuterClass$UserBaseInfo.class);
        public final PBUInt64Field uid = PBField.initUInt64(0);
        public final PBStringField nick = PBField.initString("");
        public final PBUInt32Field sex = PBField.initUInt32(0);
        public final PBStringField logo = PBField.initString("");
        public final PBStringField hometown = PBField.initString("");
        public final PBUInt64Field explicit_uid = PBField.initUInt64(0);
        public final PBStringField signature = PBField.initString("");

        /* renamed from: qq, reason: collision with root package name */
        public final PBUInt64Field f437234qq = PBField.initUInt64(0);
    };
    public TrpcUserInfoSvrOuterClass$FollowInfo follow_info = new MessageMicro<TrpcUserInfoSvrOuterClass$FollowInfo>() { // from class: trpc.qlive.trpc_user_info_svr.TrpcUserInfoSvrOuterClass$FollowInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"follow_num", "fans_num", "is_follow"}, new Object[]{0, 0, 0}, TrpcUserInfoSvrOuterClass$FollowInfo.class);
        public final PBUInt32Field follow_num = PBField.initUInt32(0);
        public final PBUInt32Field fans_num = PBField.initUInt32(0);
        public final PBUInt32Field is_follow = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<TrpcUserInfoSvrOuterClass$MedalInfo> medal_info = PBField.initRepeatMessage(TrpcUserInfoSvrOuterClass$MedalInfo.class);
    public final PBUInt64Field balance = PBField.initUInt64(0);
    public TrpcUserInfoSvrOuterClass$FansGroupInfo fans_group_info = new MessageMicro<TrpcUserInfoSvrOuterClass$FansGroupInfo>() { // from class: trpc.qlive.trpc_user_info_svr.TrpcUserInfoSvrOuterClass$FansGroupInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"has_fans_group", "fans_num", "group_name"}, new Object[]{Boolean.FALSE, 0, ""}, TrpcUserInfoSvrOuterClass$FansGroupInfo.class);
        public final PBBoolField has_fans_group = PBField.initBool(false);
        public final PBUInt32Field fans_num = PBField.initUInt32(0);
        public final PBStringField group_name = PBField.initString("");
    };
}
