package tencent.im.nearbygroup.ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.troop_search_userinfo.userinfo$UserInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NearbyGroupExt$ReqBody extends MessageMicro<NearbyGroupExt$ReqBody> {
    public static final int UINT32_TYPE_FIELD_NUMBER = 3;
    public static final int USER_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24}, new String[]{"user_info", "uint32_type"}, new Object[]{null, 0}, NearbyGroupExt$ReqBody.class);
    public userinfo$UserInfo user_info = new userinfo$UserInfo();
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
