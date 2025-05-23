package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StFavoritesFeedsPageReq extends MessageMicro<QQCircleFeedBase$StFavoritesFeedsPageReq> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f429305id = PBField.initUInt64(0);
    public final PBBoolField isAddFeedsPage = PBField.initBool(false);
    public final PBBoolField isDraft = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"id", "isAddFeedsPage", "isDraft"}, new Object[]{0L, bool, bool}, QQCircleFeedBase$StFavoritesFeedsPageReq.class);
    }
}
