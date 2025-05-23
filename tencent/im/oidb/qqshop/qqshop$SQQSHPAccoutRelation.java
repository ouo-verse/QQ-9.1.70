package tencent.im.oidb.qqshop;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class qqshop$SQQSHPAccoutRelation extends MessageMicro<qqshop$SQQSHPAccoutRelation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "binduin", Element.ELEMENT_NAME_DISTANCE, "customerservice"}, new Object[]{0L, 0L, -1, 0}, qqshop$SQQSHPAccoutRelation.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt64Field binduin = PBField.initUInt64(0);
    public final PBInt32Field distance = PBField.initInt32(-1);
    public final PBInt32Field customerservice = PBField.initInt32(0);
}
