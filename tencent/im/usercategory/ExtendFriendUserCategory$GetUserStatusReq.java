package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ExtendFriendUserCategory$GetUserStatusReq extends MessageMicro<ExtendFriendUserCategory$GetUserStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField ReqUserCategory = PBField.initBool(false);
    public final PBBoolField ReqUsedNewMatchFlag = PBField.initBool(false);
    public final PBBoolField ReqHasPersonalLabelsFlag = PBField.initBool(false);
    public final PBBoolField ReqForbiddenInfo = PBField.initBool(false);
    public final PBBoolField ReqHasWangzheRecord = PBField.initBool(false);
    public final PBBoolField ReqLastLoginTime = PBField.initBool(false);
    public final PBEnumField from = PBField.initEnum(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"ReqUserCategory", "ReqUsedNewMatchFlag", "ReqHasPersonalLabelsFlag", "ReqForbiddenInfo", "ReqHasWangzheRecord", "ReqLastLoginTime", "from"}, new Object[]{bool, bool, bool, bool, bool, bool, 0}, ExtendFriendUserCategory$GetUserStatusReq.class);
    }
}
