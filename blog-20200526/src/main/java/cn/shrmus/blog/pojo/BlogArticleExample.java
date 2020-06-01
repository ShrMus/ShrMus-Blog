package cn.shrmus.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected Integer offset;
    protected Integer limit;

    public BlogArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIsNull() {
            addCriterion("article_type_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIsNotNull() {
            addCriterion("article_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdEqualTo(Integer value) {
            addCriterion("article_type_id =", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotEqualTo(Integer value) {
            addCriterion("article_type_id <>", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThan(Integer value) {
            addCriterion("article_type_id >", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_type_id >=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThan(Integer value) {
            addCriterion("article_type_id <", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_type_id <=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIn(List<Integer> values) {
            addCriterion("article_type_id in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotIn(List<Integer> values) {
            addCriterion("article_type_id not in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("article_type_id between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_type_id not between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTopIsNull() {
            addCriterion("article_top is null");
            return (Criteria) this;
        }

        public Criteria andArticleTopIsNotNull() {
            addCriterion("article_top is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTopEqualTo(Integer value) {
            addCriterion("article_top =", value, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopNotEqualTo(Integer value) {
            addCriterion("article_top <>", value, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopGreaterThan(Integer value) {
            addCriterion("article_top >", value, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_top >=", value, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopLessThan(Integer value) {
            addCriterion("article_top <", value, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopLessThanOrEqualTo(Integer value) {
            addCriterion("article_top <=", value, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopIn(List<Integer> values) {
            addCriterion("article_top in", values, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopNotIn(List<Integer> values) {
            addCriterion("article_top not in", values, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopBetween(Integer value1, Integer value2) {
            addCriterion("article_top between", value1, value2, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleTopNotBetween(Integer value1, Integer value2) {
            addCriterion("article_top not between", value1, value2, "articleTop");
            return (Criteria) this;
        }

        public Criteria andArticleIspassIsNull() {
            addCriterion("article_ispass is null");
            return (Criteria) this;
        }

        public Criteria andArticleIspassIsNotNull() {
            addCriterion("article_ispass is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIspassEqualTo(Integer value) {
            addCriterion("article_ispass =", value, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassNotEqualTo(Integer value) {
            addCriterion("article_ispass <>", value, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassGreaterThan(Integer value) {
            addCriterion("article_ispass >", value, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_ispass >=", value, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassLessThan(Integer value) {
            addCriterion("article_ispass <", value, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassLessThanOrEqualTo(Integer value) {
            addCriterion("article_ispass <=", value, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassIn(List<Integer> values) {
            addCriterion("article_ispass in", values, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassNotIn(List<Integer> values) {
            addCriterion("article_ispass not in", values, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassBetween(Integer value1, Integer value2) {
            addCriterion("article_ispass between", value1, value2, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleIspassNotBetween(Integer value1, Integer value2) {
            addCriterion("article_ispass not between", value1, value2, "articleIspass");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickIsNull() {
            addCriterion("article_count_click is null");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickIsNotNull() {
            addCriterion("article_count_click is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickEqualTo(Integer value) {
            addCriterion("article_count_click =", value, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickNotEqualTo(Integer value) {
            addCriterion("article_count_click <>", value, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickGreaterThan(Integer value) {
            addCriterion("article_count_click >", value, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_count_click >=", value, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickLessThan(Integer value) {
            addCriterion("article_count_click <", value, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickLessThanOrEqualTo(Integer value) {
            addCriterion("article_count_click <=", value, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickIn(List<Integer> values) {
            addCriterion("article_count_click in", values, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickNotIn(List<Integer> values) {
            addCriterion("article_count_click not in", values, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickBetween(Integer value1, Integer value2) {
            addCriterion("article_count_click between", value1, value2, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleCountClickNotBetween(Integer value1, Integer value2) {
            addCriterion("article_count_click not between", value1, value2, "articleCountClick");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIsNull() {
            addCriterion("article_update_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIsNotNull() {
            addCriterion("article_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeEqualTo(Date value) {
            addCriterion("article_update_time =", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotEqualTo(Date value) {
            addCriterion("article_update_time <>", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeGreaterThan(Date value) {
            addCriterion("article_update_time >", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_update_time >=", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeLessThan(Date value) {
            addCriterion("article_update_time <", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_update_time <=", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIn(List<Date> values) {
            addCriterion("article_update_time in", values, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotIn(List<Date> values) {
            addCriterion("article_update_time not in", values, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("article_update_time between", value1, value2, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_update_time not between", value1, value2, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeIsNull() {
            addCriterion("article_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeIsNotNull() {
            addCriterion("article_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeEqualTo(Date value) {
            addCriterion("article_publish_time =", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeNotEqualTo(Date value) {
            addCriterion("article_publish_time <>", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeGreaterThan(Date value) {
            addCriterion("article_publish_time >", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_publish_time >=", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeLessThan(Date value) {
            addCriterion("article_publish_time <", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_publish_time <=", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeIn(List<Date> values) {
            addCriterion("article_publish_time in", values, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeNotIn(List<Date> values) {
            addCriterion("article_publish_time not in", values, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeBetween(Date value1, Date value2) {
            addCriterion("article_publish_time between", value1, value2, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_publish_time not between", value1, value2, "articlePublishTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}