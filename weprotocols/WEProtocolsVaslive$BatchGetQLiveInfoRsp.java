package weprotocols;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$BatchGetQLiveInfoRsp extends MessageMicro<WEProtocolsVaslive$BatchGetQLiveInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feeds"}, new Object[]{null}, WEProtocolsVaslive$BatchGetQLiveInfoRsp.class);
    public final PBRepeatMessageField<WEProtocolsVaslive$StFeed> feeds = PBField.initRepeatMessage(WEProtocolsVaslive$StFeed.class);
}
